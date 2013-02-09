package com.sec.android.app.music;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class CorePlayerServiceConnection implements ServiceConnection {

    private ICorePlayerService mService;

	public void onServiceConnected(ComponentName name, IBinder boundService) {
        Log.i("CorePlayerServiceConnection - S3", "Connected! Name: " + name.getClassName());

        // This is the important line
        mService = ICorePlayerService.Stub.asInterface(boundService);

        // If all went well, now we can use the interface
        try {
            if (mService.isPlaying()) {
                Log.i("CorePlayerServiceConnection", "Music player is playing.");
            } else {
                Log.i("CorePlayerServiceConnection", "Music player is not playing.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        mService = null;
        Log.i("CorePlayerServiceConnection", "Disconnected!");
    }
    
	public long getDuration() {
		try {
			return mService.getDuration();
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
			return mService.getIndexOfPlayList();
		} catch (RemoteException e) {
			Log.e("MediaConnection", "Failed to get the Index Of the Play List");
		}
		
		return -1;
	}
}