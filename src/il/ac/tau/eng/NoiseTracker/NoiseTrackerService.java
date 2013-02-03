package il.ac.tau.eng.NoiseTracker;
import il.ac.tau.eng.Utils.Logger;
import il.ac.tau.eng.Utils.Logger.LogLevel;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class NoiseTrackerService extends Service {
	private static final String PLAYSTATE_CHANGED = "com.android.music.playstatechanged";
	private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
	
	private static Map<String, String> sSongsMap  = new HashMap<String, String>();
	private MediaBroadcastReceiver mMediaReceiver;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
    public void onCreate() {
		String methodName = "NoiseTrackerService.onCreate";
		Logger.SysAppend(LogLevel.INFO, ">>>", methodName);
		
		resolveSongsContent();
		mMediaReceiver = new MediaBroadcastReceiver((AudioManager)getSystemService(Context. AUDIO_SERVICE), sSongsMap);

		IntentFilter iF = new IntentFilter();
		iF.addAction(PLAYSTATE_CHANGED);
		iF.addAction(VOLUME_CHANGED_ACTION);
	
		Logger.SysAppend(LogLevel.DEBUG, "Registering to Media Broadcast Receiver", methodName);
		registerReceiver(mMediaReceiver, iF);
		
		Logger.SysAppend(LogLevel.DEBUG, "NoiseTrackerService was created successfully and now running..", methodName);
		Toast.makeText(this, "NoiseTrackerService is now running..", Toast.LENGTH_SHORT).show();
	    
    	Logger.SysAppend(LogLevel.INFO, "<<<\n", methodName);
    }
	
	@Override
	public void onDestroy() {
		String methodName = "NoiseTrackerService.onDestroy";
		Logger.SysAppend(LogLevel.INFO, ">>> " + methodName, methodName);

		super.onDestroy();
		
		if (mMediaReceiver != null) {
			unregisterReceiver(mMediaReceiver);
			Logger.SysAppend(LogLevel.DEBUG, "Unregistered Media Broadcast Receiver", methodName);
		}
		
		
		Logger.SysAppend(LogLevel.INFO, "<<<\n" + methodName, methodName);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
	    
	    String methodName = "NoiseTrackerService.onStartCommand";

		try {
			Logger.initLogger();
		} catch (IOException e) {
			Log.e("NoiseTrackerService.onStartCommand", "Logger was not created! Details: " + e.getMessage());
		}

		Logger.SysAppend(LogLevel.INFO, ">>>", methodName);
		Logger.SysAppend(LogLevel.INFO, "<<<\n", methodName);
	    
	    return START_STICKY;
	}
	
	private void resolveSongsContent() {
		try {
			
			ContentResolver contentResolver = getContentResolver();
			Uri uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
			Cursor cursor = contentResolver.query(uri, null, null, null, null);
			
			if (!cursor.moveToFirst()) {
				Logger.SysAppend(LogLevel.WARRNING, "No songs to resolve", "NoiseTrackerService.resolveSongsContent");
			} else {
				
				int isMusicIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.IS_MUSIC);
				int titleIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.TITLE);
				int artistIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.ARTIST);
				int albumIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.ALBUM);
				int durationIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.DURATION);
				int displayIndex = cursor.getColumnIndex(android.provider.MediaStore.Audio.AudioColumns.DISPLAY_NAME);
				
				for (int i = 0; i < cursor.getCount(); i++) {
					if (!cursor.getString(isMusicIndex).equals("0")) {
						String strTimeInMilli = cursor.getString(durationIndex);
						long milliseconds = Long.parseLong(strTimeInMilli, 10);
						int seconds = (int) (milliseconds / 1000) % 60 ;
						int minutes = (int) ((milliseconds / (1000*60)) % 60);
						
						String track = cursor.getString(titleIndex);
						sSongsMap.put(track,  "   Display = "  + cursor.getString(displayIndex) +
											"\n   Track = "    + cursor.getString(titleIndex) +
											"\n   Album = "    + cursor.getString(albumIndex) +
											"\n   Artist = "   + cursor.getString(artistIndex) +
											"\n   Duration = " + (minutes < 10 ? ("0"+minutes) : minutes) + ":" + (seconds < 10 ? ("0"+seconds) : seconds));
					}
					
					cursor.moveToNext();
				}
				
				Logger.SysAppend(LogLevel.DEBUG, "Done resolving songs to hashtable", "NoiseTrackerService.resolveSongsContent");
			}
		} catch (Exception e) {
			System.out.println("No sdcard presents");
		}
	}
	
//	private boolean isMyServiceRunning() {
//	    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
//	        if (NoiseTrackerService.class.getName().equals(service.service.getClassName())) {
//	            return true;
//	        }
//	    }
//	    
//	    return false;
//	}
}
