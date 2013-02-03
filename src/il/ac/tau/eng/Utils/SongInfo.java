package il.ac.tau.eng.Utils;

public class SongInfo {
	private String mArtist = "";
	private String mAlbum = "";
	private String mTrack = "";
	private int mVolume = 0;
	
	public long TimeStamp = 0;
	public SongState State; 
	
	
	public SongInfo()
	{
		State = SongState.Empty;
	}
	
	public void Clone(SongInfo iSongInfo)
	{
		if (iSongInfo != null)
		{
			mArtist = iSongInfo.getArtist();
			mAlbum = iSongInfo.getAlbum();
			mTrack = iSongInfo.getTrack();
			mVolume = iSongInfo.getVolume();	
			//TimeStamp = iSongInfo.TimeStamp;
			State = iSongInfo.State;
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
	
	public enum SongState {
		Empty, Play, Pause, Resume, Stop
	}
	
}
