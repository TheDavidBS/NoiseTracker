package il.ac.tau.eng.NoiseTracker;
import il.ac.tau.eng.Utils.Logger;
import il.ac.tau.eng.Utils.SongInfo;
import il.ac.tau.eng.Utils.Utils;
import il.ac.tau.eng.Utils.Logger.LogLevel;
import il.ac.tau.eng.Utils.SongInfo.SongState;
import java.util.HashMap;
import java.util.Map;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

public class MediaBroadcastReceiver extends BroadcastReceiver  {
	private static final String PLAYSTATE_CHANGED = "com.android.music.playstatechanged";
	private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";

	private static AudioManager sAudioManager = null;
	private static SongInfo sCurrentSong = new SongInfo();
	private static SongInfo sPreviousSong = new SongInfo();
	private static long sPauseTime = 0;
	
	private static Map<String, String> sSongsMap  = new HashMap<String, String>();
	
	public MediaBroadcastReceiver(AudioManager audioManager, Map<String, String> songMap) {
		sAudioManager = audioManager;
		sSongsMap = songMap;
	}
	
	private boolean isPlaying(String iCallerMethodName) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean bIsMusicActive = sAudioManager.isMusicActive();
		Logger.SysAppend(LogLevel.DEBUG, "Is Music Active = " + ((bIsMusicActive) ? "Yes" : "No"), iCallerMethodName);
		
		return bIsMusicActive;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		String methodName = "MediaReceiver.onReceive";
		Logger.SysAppend(LogLevel.INFO, ">>>", methodName);
		
		String action = intent.getAction();
		Logger.SysAppend(LogLevel.WARRNING, "Action  -> " + action, methodName);

		boolean bIsMusicActive = isPlaying(methodName);

		// Volume change event
		if (action.equals(VOLUME_CHANGED_ACTION)) {
			int volume = (int)sAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
			
			sPreviousSong.setVolume(volume);
			Logger.SysAppend(LogLevel.DEBUG, "VOLUME_CHANGED_EVENT: " + volume, methodName);
		}
		
		// Play, Resume or Pause
		if (action.equals(PLAYSTATE_CHANGED)) {
			// updating the volume
			sCurrentSong.setVolume((int)sAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
			
			 if (bIsMusicActive) {
				
				 // same song - resumed from pause
				if(sCurrentSong.getArtist().equals(intent.getStringExtra("artist"))
					&& sCurrentSong.getAlbum().equals(intent.getStringExtra("album"))
					&& sCurrentSong.getTrack().equals(intent.getStringExtra("track")) ) {
					sCurrentSong.State = SongState.Resume;
					// updating the pause delay time
					 sPreviousSong.TimeStamp += (System.currentTimeMillis() -  sPauseTime);
				} else {
					// this is a new song
					sCurrentSong.TimeStamp = System.currentTimeMillis();
					
					if (sCurrentSong.State == SongState.Pause) {
						sPreviousSong.TimeStamp += (System.currentTimeMillis() -  sPauseTime);
					}
					
					sCurrentSong.State = SongState.Play;
					sCurrentSong.setArtist(intent.getStringExtra("artist"));
					sCurrentSong.setAlbum(intent.getStringExtra("album"));
					sCurrentSong.setTrack(intent.getStringExtra("track"));
					
					sPauseTime = 0;
					logSongToCsvFile(methodName);
					
					sPreviousSong.TimeStamp = sCurrentSong.TimeStamp;
					sPreviousSong.Clone(sCurrentSong);
				}
			} else {
				sPauseTime = System.currentTimeMillis();
				sCurrentSong.State = SongState.Pause;
			}
		}
		
		Logger.SysAppend(LogLevel.DEBUG, "Current Song State: " + sCurrentSong.State.toString(), methodName);
		Logger.SysAppend(LogLevel.INFO, "<<<\n", methodName);
	}

	private void logSongToCsvFile(String iCallerMethodName) {
		// logging the played track data to the CSV file 
		String prevTrack = sPreviousSong.getTrack();
		
		if(prevTrack == null || prevTrack.equals("")) {
			return;
		}
		
		String prevTrackInfo = sSongsMap.get(prevTrack);
		String infoLine = prevTrackInfo + 
						  "\n   Listening Duration = " + Utils.getTimeDiff(sPreviousSong.TimeStamp, sCurrentSong.TimeStamp) +
						  "\n   State = " + sPreviousSong.State.toString() + 
						  "\n   Volume = " + sPreviousSong.getVolume();
		
		String lineToLog = Utils.createCsvLine(infoLine);
		
		Logger.CsvAppend(lineToLog);
		Logger.SysAppend(LogLevel.DEBUG, "Info:\n" + infoLine + "\n" , iCallerMethodName);
	}
}