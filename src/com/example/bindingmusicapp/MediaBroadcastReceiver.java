package com.example.bindingmusicapp;
import com.example.tools.Logger;
import com.example.tools.SongInfo;
import com.example.tools.Utils;
import com.example.tools.Logger.LogLevel;
import com.example.tools.SongInfo.eSongState;

import java.util.HashMap;
import java.util.Map;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;

public class MediaBroadcastReceiver extends BroadcastReceiver  {
	private static final String PLAYSTATE_CHANGED = "com.android.music.playstatechanged";
	private static final String PLAYSTATE_CHANGED_JRTSTUDIO = "com.jrtstudio.music.playstatechanged";
	private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
	
	private static AudioManager sAudioManager = null;
	private static SongInfo sCurrentSong = new SongInfo();
	private static SongInfo sPreviousSong = new SongInfo();
	private static boolean sIsVolumeButtonPressedDown = false;
	
	private static long sStartTimeInMilli_System = 0;
	
	private static Map<String, String> sSongsMap  = new HashMap<String, String>();
	private com.android.music.player.service.CorePlayerServiceConnection mCorePlayer_W = null;
	private com.sec.android.app.music.CorePlayerServiceConnection mCorePlayer_S3 = null;
	private com.jrtstudio.music.MediaPlayerServiceConnection mMediaPlayer_Motorola = null;
	
	public MediaBroadcastReceiver(AudioManager audioManager, Map<String, String> songMap, ServiceConnection player, Utils.eAndroidType androidType) {
		sAudioManager = audioManager;
		sSongsMap = songMap;
		if (androidType == Utils.eAndroidType.SAMSUNG_W) {
			mCorePlayer_W = (com.android.music.player.service.CorePlayerServiceConnection)player;
		} else if (androidType == Utils.eAndroidType.SAMSUNG_S3) {
			mCorePlayer_S3 = (com.sec.android.app.music.CorePlayerServiceConnection)player;
		} else {
			mMediaPlayer_Motorola = (com.jrtstudio.music.MediaPlayerServiceConnection)player;
		}
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		boolean bIsMusicActive = false;
		
		String methodName = "MediaReceiver.onReceive";
		Logger.SysAppend(LogLevel.INFO, ">>>", methodName);
		
		String action = intent.getAction();
		Logger.SysAppend(LogLevel.WARRNING, "Action  -> " + action, methodName);

		bIsMusicActive = isPlaying();
		
		long sysTime = System.currentTimeMillis();

		// Volume change event
		if (action.equals(VOLUME_CHANGED_ACTION)) {
			if(!sIsVolumeButtonPressedDown) {
				int volume = (int)sAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
				
				sCurrentSong.setVolume(volume);
				Logger.SysAppend(LogLevel.DEBUG, "VOLUME_CHANGED_EVENT: " + volume, methodName);
				
				// Log to CSV 
				log(sCurrentSong, true);
				sIsVolumeButtonPressedDown = true;
				
			} else {
				// This is a PATCH for the double interrupt we receive once the volume 
				//  button is being pressed
				sIsVolumeButtonPressedDown = false;
			}
		}
				
		// PLAY,   RESUME   or   PAUSE
		if (action.equals(PLAYSTATE_CHANGED) || action.equals(PLAYSTATE_CHANGED_JRTSTUDIO)) {
			int currentSongPositionInMilli;
			// updating the volume
			sCurrentSong.setVolume((int)sAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
			
			currentSongPositionInMilli = getPlaylistIndex();
			
			if (bIsMusicActive) {

				// same song - RESUME from PAUSE
				if(sCurrentSong.getArtist().equals(intent.getStringExtra("artist")) 
						&& sCurrentSong.getAlbum().equals(intent.getStringExtra("album")) 
						&& sCurrentSong.getTrack().equals(intent.getStringExtra("track")) ) {
					
					sCurrentSong.State = eSongState.Resume;
					
					// updating the pause delay time
					sCurrentSong.StartTimeInMilli = currentSongPositionInMilli;
					sStartTimeInMilli_System = sysTime;
				
				} else {
					// PLAY - NEW SONG (NEXT)
					
					sPreviousSong.Clone(sCurrentSong);
					sPreviousSong.StartTimeInMilli = sCurrentSong.StartTimeInMilli;
					sPreviousSong.StopTimeInMilli = sCurrentSong.StartTimeInMilli + (int)(sysTime - sStartTimeInMilli_System);
					
					sCurrentSong.setDuration(getSongDuration());
					sStartTimeInMilli_System = sysTime;
					sCurrentSong.State = eSongState.Play;
					sCurrentSong.setArtist(intent.getStringExtra("artist"));
					sCurrentSong.setAlbum(intent.getStringExtra("album"));
					sCurrentSong.setTrack(intent.getStringExtra("track"));
					sCurrentSong.StartTimeInMilli = currentSongPositionInMilli;
					
					if (sPreviousSong.State != eSongState.Pause) {
						// start to play from PAUSE a new song
						log(sPreviousSong, false);
					}
				}

			// PAUSE or STOP
			} else {
				
				sCurrentSong.StopTimeInMilli = currentSongPositionInMilli;
				
				// Log to CSV 
				log(sCurrentSong, false);
				
				sCurrentSong.State = eSongState.Pause;
			}
		}
		
		Logger.SysAppend(LogLevel.INFO, "<<<\n", methodName);
	}

	private int getSongDuration() {
		int duration = -1;
		
		if (mCorePlayer_W != null) {
			duration = (int)(mCorePlayer_W).getDuration();
		} else if (mCorePlayer_S3 != null) {
			duration = (int)(mCorePlayer_S3).getDuration();
		} else if (mMediaPlayer_Motorola != null) {
			duration = (int)(mMediaPlayer_Motorola).getDuration();
		}
		
		return duration;
	}

	private int getPlaylistIndex() {
		int index = -1;
		
		if (mCorePlayer_W != null) {
			index = (int)(mCorePlayer_W).getIndexOfPlayList();
		} else if (mCorePlayer_S3 != null) {
			index = (int)(mCorePlayer_S3).getIndexOfPlayList();
		} else if (mMediaPlayer_Motorola != null) {
			index = (int)(mMediaPlayer_Motorola).getIndexOfPlayList();
		}
		
		return  index;
	}

	private boolean isPlaying() {
		boolean bIsMusicActive = false;
		
		if (mCorePlayer_W != null) {
			bIsMusicActive = mCorePlayer_W.isPlaying();
		} else if (mCorePlayer_S3 != null) {
			bIsMusicActive = mCorePlayer_S3.isPlaying();
		} else if (mMediaPlayer_Motorola != null) {
			bIsMusicActive = mMediaPlayer_Motorola.isPlaying();
		}
		
		return bIsMusicActive;
	}
	
	private void log(SongInfo song, boolean isVolumeUpdateOnly) {
		// logging the played track data to the CSV file 
		String infoLine = "";
		String trackName = song.getTrack();
		
				
		if(trackName == null || trackName.equals("")) {
			return;
		}
		
		if (isVolumeUpdateOnly) {
			infoLine = sSongsMap.get(song.getTrack()) + 
					"\n   Duration (clock) = " + Utils.getClockTime(song.getDuration()) +
					"\n	  Start Listening From = -" +
					"\n	  Volume Change Time = " + Utils.getClockTime(getPlaylistIndex()) +
					"\n   Listening Duration = -" +
					"\n   State = " + song.State.toString() + 
					"\n   Volume = " + song.getVolume() +
					"\n   Event = VolumeChanged Event";
		} else {

			infoLine = sSongsMap.get(song.getTrack()) + 
				"\n   Duration (clock) = " + Utils.getClockTime(song.getDuration()) +
				"\n	  Start Listening From = " + Utils.getClockTime(song.StartTimeInMilli) +
				"\n	  Pause/Stop Time = " + Utils.getClockTime(song.StopTimeInMilli) +
				"\n   Listening Duration = " + Utils.getClockTimeDiff(song.StartTimeInMilli, song.StopTimeInMilli) +
				"\n   State = " + song.State.toString() + 
				"\n   Volume = " + song.getVolume();
		}
		
		String lineToLog = Utils.createCsvLine(infoLine);
		Logger.CsvAppend(lineToLog);
		Logger.SysAppend(LogLevel.WARRNING, "Info:\n" + infoLine + "\n" , "MediaReceiver.onReceive");
	}
}