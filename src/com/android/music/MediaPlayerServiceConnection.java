package com.android.music;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MediaPlayerServiceConnection implements ServiceConnection {

    private IMediaPlaybackService mService;

	public void onServiceConnected(ComponentName name, IBinder boundService) {
        Log.i("MediaPlayerServiceConnection - Default Android", "Connected! Name: " + name.getClassName());

        // This is the important line
        mService = IMediaPlaybackService.Stub.asInterface(boundService);

        // If all went well, now we can use the interface
        try {
            Log.i("MediaPlayerServiceConnection", "Playing track: " + mService.getTrackName());
                 Log.i("MediaPlayerServiceConnection", "By artist: " + mService.getArtistName());
            if (mService.isPlaying()) {
                Log.i("MediaPlayerServiceConnection", "Music player is playing.");
            } else {
                Log.i("MediaPlayerServiceConnection", "Music player is not playing.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        mService = null;
        Log.i("MediaPlayerServiceConnection", "Disconnected!");
    }
	
    public long getDuration() {
		try {
			return mService.duration();
		} catch (RemoteException e) {
			Log.e("MediaConnection", "Failed to get Duration");
			return -1;
		}    		
	}
	
   	public boolean isPlaying() {
		try {
			return mService.isPlaying();
		} catch (RemoteException e) {
			Log.e("MediaConnection", "Failed to get Playstate");
		}
		
		return false;
	}
   	
   	public int getIndexOfPlayList() {
		try {
			return (int) mService.position();
		} catch (RemoteException e) {
			Log.e("MediaConnection", "Failed to get the Index Of the Play List");
		}
		
		return -1;
	}
}