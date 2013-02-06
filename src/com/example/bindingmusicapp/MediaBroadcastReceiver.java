package com.example.bindingmusicapp;
import com.android.music.player.service.CorePlayerServiceConnection;
import com.example.tools.Logger;
import com.example.tools.SongInfo;
import com.example.tools.Utils;
import com.example.tools.Logger.LogLevel;
import com.example.tools.SongInfo.SongState;

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
	
	private static long sStartTimeInMilli_System = 0;
	
	private static Map<String, String> sSongsMap  = new HashMap<String, String>();
	private CorePlayerServiceConnection mCorePlayer;
	
	public MediaBroadcastReceiver(AudioManager audioManager, Map<String, String> songMap, CorePlayerServiceConnection corePlayer) {
		sAudioManager = audioManager;
		sSongsMap = songMap;
		mCorePlayer = corePlayer;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		String methodName = "MediaReceiver.onReceive";
		Logger.SysAppend(LogLevel.INFO, ">>>", methodName);
		
		String action = intent.getAction();
		Logger.SysAppend(LogLevel.WARRNING, "Action  -> " + action, methodName);

		boolean bIsMusicActive = mCorePlayer.isPlaying();
		long sysTime = System.currentTimeMillis();

		// Volume change event
		if (action.equals(VOLUME_CHANGED_ACTION)) {
			int volume = (int)sAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
			
			sCurrentSong.setVolume(volume);
			Logger.SysAppend(LogLevel.DEBUG, "VOLUME_CHANGED_EVENT: " + volume, methodName);
		}
		
		// PLAY,   RESUME   or   PAUSE
		if (action.equals(PLAYSTATE_CHANGED)) {
			// updating the volume
			sCurrentSong.setVolume((int)sAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
			
			int currentSongPositionInMilli = mCorePlayer.getIndexOfPlayList();
						
			if (bIsMusicActive) {

				// same song - RESUME from PAUSE
				if(sCurrentSong.getArtist().equals(intent.getStringExtra("artist")) 
						&& sCurrentSong.getAlbum().equals(intent.getStringExtra("album")) 
						&& sCurrentSong.getTrack().equals(intent.getStringExtra("track")) ) {
					
					sCurrentSong.State = SongState.Resume;
					
					// updating the pause delay time
					sCurrentSong.StartTimeInMilli = currentSongPositionInMilli;
					sStartTimeInMilli_System = sysTime;
				
				} else {
					// PLAY - NEW SONG (NEXT)
					
					sPreviousSong.Clone(sCurrentSong);
					sPreviousSong.StartTimeInMilli = sCurrentSong.StartTimeInMilli;
					sPreviousSong.StopTimeInMilli = sCurrentSong.StartTimeInMilli + (int)(sysTime - sStartTimeInMilli_System);
					
					sCurrentSong.setDuration((int)mCorePlayer.getDuration());
					sStartTimeInMilli_System = sysTime;
					sCurrentSong.State = SongState.Play;
					sCurrentSong.setArtist(intent.getStringExtra("artist"));
					sCurrentSong.setAlbum(intent.getStringExtra("album"));
					sCurrentSong.setTrack(intent.getStringExtra("track"));
					sCurrentSong.StartTimeInMilli = currentSongPositionInMilli;
					
					if (sPreviousSong.State != SongState.Pause) {
						// start to play from PAUSE a new song
						
						// Log to CSV 
						log(sPreviousSong);
					}
				}

			// PAUSE or STOP
			} else {
				
				sCurrentSong.StopTimeInMilli = currentSongPositionInMilli;
				
				// Log to CSV 
				log(sCurrentSong);
				
				sCurrentSong.State = SongState.Pause;
			}
		}
		
		Logger.SysAppend(LogLevel.INFO, "<<<\n", methodName);
	}
	
	private static void log(SongInfo song) {
		String infoLine = sSongsMap.get(song.getTrack()) + 
				"\n   Duration (clock) = " + Utils.getClockTime(song.getDuration()) +
				"\n	  Start Listening From = " + Utils.getClockTime(song.StartTimeInMilli) +
				"\n	  Pause/Stop Time = " + Utils.getClockTime(song.StopTimeInMilli) +
				"\n   Listening Duration = " + Utils.getClockTimeDiff(song.StartTimeInMilli, song.StopTimeInMilli) +
				"\n   State = " + song.State.toString() + 
				"\n   Volume = " + song.getVolume();
				
				String lineToLog = Utils.createCsvLine(infoLine);
				Logger.CsvAppend(lineToLog);
				Logger.SysAppend(LogLevel.WARRNING, "Info:\n" + infoLine + "\n" , "MediaReceiver.onReceive");
	}
}