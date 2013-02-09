package com.example.tools;

public class SongInfo {
	private String mArtist = "";
	private String mAlbum = "";
	private String mTrack = "";
	private int mVolume = 0;
	private int mDuration = 0;
	
	public int StartTimeInMilli = 0;
	public int StopTimeInMilli = 0;
	public eSongState State; 
	
	
	public SongInfo()
	{
		State = eSongState.Empty;
	}
	
	public void Clone(SongInfo iSongInfo)
	{
		if (iSongInfo != null)
		{
			mArtist = iSongInfo.getArtist();
			mAlbum = iSongInfo.getAlbum();
			mTrack = iSongInfo.getTrack();
			mVolume = iSongInfo.getVolume();
			State = iSongInfo.State;
			mDuration = iSongInfo.getDuration();
		}
	}
	
	public String getArtist() {
		return mArtist;
	}
	
	public int getVolume() {
		return mVolume;
	}
	
	public String getAlbum() {
		return mAlbum;
	}
	
	public String getTrack() {
		return mTrack;
	}
	
	public void setArtist(String iArtist) {
		mArtist = iArtist;
	}
	
	public void setAlbum(String iAlbum) {
		mAlbum = iAlbum;
	}
	
	public void setTrack(String iTrack) {
		mTrack = iTrack;
	}
	
	public void setVolume(int iVolume) {
		mVolume = iVolume;
	}
	
	public int getDuration() {
		return mDuration;
	}

	public void setDuration(int mDuration) {
		this.mDuration = mDuration;
	}

	public enum eSongState {
		Empty, Play, Pause, Resume, Stop
	}
	
}
