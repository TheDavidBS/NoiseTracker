package com.example.bindingmusicapp;
import com.android.music.player.service.CorePlayerServiceConnection;
import com.example.tools.Logger;
import com.example.tools.Utils;
import com.example.tools.Logger.LogLevel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import android.app.ActivityManager;
import android.app.Service;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MainService extends Service {
	private static final String PLAYSTATE_CHANGED = "com.android.music.playstatechanged";
	private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
	private static final String PLAYSTATE_CHANGED_JRTSTUDIO = "com.jrtstudio.music.playstatechanged";
	
	private static final String CORE_PLAYER_SERVICE_W =  "com.android.music.player.service.CorePlayerService";
	private static final String CORE_PLAYER_SERVICE_S3 =  "com.sec.android.app.music.CorePlayerService";
	private static final String MEDIA_PLAYBACK_SERVICE =  "com.android.music.MediaPlaybackService";
	
	private static String mServiceNameToBind = ""; 
	
	private static Map<String, String> sSongsMap  = new HashMap<String, String>();
	private MediaBroadcastReceiver mMediaReceiver;
	private ServiceConnection mConnection;
	
	private Utils.eAndroidType mAndroidType = Utils.eAndroidType.SAMSUNG_W;
	
	boolean mIsBoundToCorePlayer = false;
	boolean mIsBoundToMediaPlayer = false;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	    String methodName = "MainService.onStartCommand";

		try {
			Logger.initLogger();
		} catch (IOException e) {
			Log.e("MainService.onStartCommand", "Logger was not created! Details: " + e.getMessage());
		}

		Logger.SysAppend(LogLevel.INFO, ">>>", methodName);
		Logger.SysAppend(LogLevel.INFO, "<<<\n", methodName);
	    
	    return START_STICKY;
	}
	
	
	@Override
    public void onCreate() {
		String methodName = "MainService.onCreate";
		
		try {
			Logger.initLogger();
		} catch (IOException e) {
			Log.e("MainService.onStartCommand", "Logger was not created! Details: " + e.getMessage());
		}
		
		Logger.SysAppend(LogLevel.INFO, ">>>", methodName);
		
		resolveSongsContent();
		
		// binding the core player music app to our service
		boolean bIsServiceFound = findServiceToBind();
		
		if(!bIsServiceFound) {
			Logger.SysAppend(LogLevel.ERROR, "The Music Service to bind dose not exists - closing the service", methodName);
			onDestroy();
			return;
		}
		
		Intent bindIntent = new Intent();
		
		if(mServiceNameToBind.equals(CORE_PLAYER_SERVICE_W)){
			mAndroidType = Utils.eAndroidType.SAMSUNG_W;
			bindIntent.setClassName("com.android.music", mServiceNameToBind);
			mConnection = new CorePlayerServiceConnection();
			mIsBoundToCorePlayer = this.bindService(bindIntent, mConnection, 0);
			
		} else  if (mServiceNameToBind.equals(CORE_PLAYER_SERVICE_S3)) {
			mAndroidType = Utils.eAndroidType.SAMSUNG_S3;
			bindIntent.setClassName("com.sec.android.app.music.", mServiceNameToBind);
			mConnection = new com.sec.android.app.music.CorePlayerServiceConnection();
			mIsBoundToCorePlayer = this.bindService(bindIntent, mConnection, 0);
			
		} else {
			bindIntent.setClassName("com.jrtstudio.music", mServiceNameToBind);
			mAndroidType = Utils.eAndroidType.MOTOROLA;
			mConnection = new com.jrtstudio.music.MediaPlayerServiceConnection();
			mIsBoundToMediaPlayer = this.bindService(bindIntent, mConnection, 0);
		}
		
		if(mIsBoundToCorePlayer || mIsBoundToMediaPlayer) {
			Logger.SysAppend(LogLevel.DEBUG, "bind successfully", methodName);
		} else {
			Logger.SysAppend(LogLevel.ERROR, "fail to bind the Player service", methodName);
			mConnection = null;
			onDestroy();
			return;
		}
		
		mMediaReceiver = new MediaBroadcastReceiver(
				(AudioManager)getSystemService(Context. AUDIO_SERVICE), 
				sSongsMap, 
				mConnection,
				mAndroidType); 

		IntentFilter iF = new IntentFilter();
		iF.addAction(PLAYSTATE_CHANGED);
		iF.addAction(VOLUME_CHANGED_ACTION);
		iF.addAction(PLAYSTATE_CHANGED_JRTSTUDIO);
		
		Logger.SysAppend(LogLevel.DEBUG, "Registering to Media Broadcast Receiver", methodName);
		registerReceiver(mMediaReceiver, iF);
		
		Logger.SysAppend(LogLevel.DEBUG, "MainService was created successfully and now running..", methodName);
		Toast.makeText(this, "MainService is now running..", Toast.LENGTH_SHORT).show();
		
    	Logger.SysAppend(LogLevel.INFO, "<<<\n", methodName);
    }
	
	@Override
	public void onDestroy() {
		String methodName = "MainService.onDestroy";
		Log.i(methodName, ">>> " + methodName);

		super.onDestroy();
		
		if (mMediaReceiver != null) {
			unregisterReceiver(mMediaReceiver);
			Log.i(methodName, "Unregistered Media Broadcast Receiver");
		}
		
		if (mIsBoundToCorePlayer) {
			this.unbindService(mConnection);
		}
		
		Log.i(methodName, "<<<\n" + methodName);
	}
	
	private void resolveSongsContent() {
		try {
			
			ContentResolver contentResolver = getContentResolver();
			Uri uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
			Cursor cursor = contentResolver.query(uri, null, null, null, null);
			
			if (!cursor.moveToFirst()) {
				Logger.SysAppend(LogLevel.WARRNING, "No songs to resolve", "MainService.resolveSongsContent");
			} else {
				
				int isMusicIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.IS_MUSIC);
				int FileNameIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.DISPLAY_NAME);
				int titleIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.TITLE);
				int albumIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.ALBUM);
				int artistIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.ARTIST);
				
				for (int i = 0; i < cursor.getCount(); i++) {
					if (!cursor.getString(isMusicIndex).equals("0")) {
						
						String track = cursor.getString(titleIndex);
						sSongsMap.put(track,  "   File Name = "  + cursor.getString(FileNameIndex) +
											"\n   Track = "    + cursor.getString(titleIndex) +
											"\n   Album = "    + cursor.getString(albumIndex) +
											"\n   Artist = "   + cursor.getString(artistIndex));
					}
					
					cursor.moveToNext();
				}
				
				Logger.SysAppend(LogLevel.DEBUG, "Done resolving songs to hashtable", "MainService.resolveSongsContent");
			}
		} catch (Exception e) {
			System.out.println("No sdcard presents");
		}
	}
	
	// TODO: Debug method
	private boolean findServiceToBind() {
	    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	    	if (service.service.getClassName().equals(CORE_PLAYER_SERVICE_W)) {
	    		mServiceNameToBind = CORE_PLAYER_SERVICE_W;
	    		Log.i("Service: ", service.service.getClassName() + " found");
	    		break;
	    	}
	    	
	    	if (service.service.getClassName().equals(MEDIA_PLAYBACK_SERVICE)) {
	    		mServiceNameToBind = MEDIA_PLAYBACK_SERVICE;
	    		Log.i("Service: ", service.service.getClassName() + " found");
	    		break;
	    	}
	    	
	    	if (service.service.getClassName().equals(CORE_PLAYER_SERVICE_S3)) {
	    		mServiceNameToBind = CORE_PLAYER_SERVICE_S3;
	    		Log.i("Service: ", service.service.getClassName() + " found");
	    		break;
	    	}
	    	
	    }
	    
	    if(mServiceNameToBind.equals("")){
	    	Log.e("Service: ", "No service to bind was found!");
	    	return false;
	    }
	    
	    return true;
	}
}
