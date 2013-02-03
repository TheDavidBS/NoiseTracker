package il.ac.tau.eng.Utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Environment;
import android.util.Log;

public class Logger {
	private static final String LOGS_DIRECTORY = "NoiseTrackerDBS";
	private static final String SYS_LOG_FILENAME = "SystemLog.txt";
	private static final String CSV_LOG_FILENAME = "ApplicationLog.csv";
	private static File sSystemFile = null;
	private static File sCsvFile = null;
	
	public static void initLogger() throws IOException
	{
		// adding a validation for the external storage access
		if (!isExternalStorageWritable()) {
			SysAppend(LogLevel.ERROR, "The External Storage isn't Writable!", "initSysLogger");
			throw new IOException("The External Storage isn't Writable!");
		}
		
		File dir = new File(Environment.getExternalStorageDirectory(), LOGS_DIRECTORY);
		
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		sSystemFile = new File(dir, SYS_LOG_FILENAME);
		sCsvFile = new File(dir, CSV_LOG_FILENAME);
		
		if (!sSystemFile.exists()) {
			sSystemFile.createNewFile();
		} 
		
		if (!sCsvFile.exists()) {
			sCsvFile.createNewFile();
			// the csv header
			try {
				BufferedWriter buf = new BufferedWriter(new FileWriter(sCsvFile, true));
				buf.append("LogTime, MP3/WAV File Name, Track, Album, Artist,Track Duration, Listening Duration, State, Volume");
				buf.newLine();
				buf.close();
			} catch (IOException e) { }
		} 
	}
	
	
	/***
	 * An additional method to checks if external storage is available for read and write
	 * @return true - in case the external storage is available for read and write
	 */
	public static boolean isExternalStorageWritable() {
	    String state = Environment.getExternalStorageState();
	    if (Environment.MEDIA_MOUNTED.equals(state)) {
	        return true;
	    }
	    
	    return false;
	}
	
	public static boolean SysAppend(LogLevel i_eLogLevel, String i_Msg, String i_CallerMethod) {
		boolean ret = true;
		
		try {
			switch (i_eLogLevel) {
			case ERROR:
				Log.e(i_CallerMethod, i_Msg);
				break;
			case WARRNING:
				Log.w(i_CallerMethod, i_Msg);
				break;
			case INFO:
				Log.i(i_CallerMethod, i_Msg);
				break;
			case DEBUG:
				Log.d(i_CallerMethod, i_Msg);
				break;
				
			default:
				Log.w(i_CallerMethod, i_Msg);
				break;
			}
			
			// BufferedWriter for performance, true to set append to file flag.
			BufferedWriter buf = new BufferedWriter(new FileWriter(sSystemFile, true));
			String dateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").format(new Date());
			buf.append(dateTime + "\t" + i_eLogLevel + ":\t" + i_CallerMethod + ": " + i_Msg);
			buf.newLine();
			buf.close();
			
		} catch (IOException e) {
			ret = false;
		}
		
		return ret;
	}
	
	public static boolean CsvAppend(String iLog) {
		boolean ret = true;
		try {
			BufferedWriter buf = new BufferedWriter(new FileWriter(sCsvFile, true));
			String dateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").format(new Date());
			buf.append(dateTime + ", " + iLog);
			buf.newLine();
			buf.close();

		} catch (IOException e) {
			ret = false;
		}

		return ret;
	}
	
	// States the log level
	public enum LogLevel {
		ERROR, WARRNING, INFO, DEBUG
	}
}
