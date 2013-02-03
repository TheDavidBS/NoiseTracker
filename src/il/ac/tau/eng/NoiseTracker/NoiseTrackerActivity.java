package il.ac.tau.eng.NoiseTracker;
import il.ac.tau.eng.Utils.Logger;
import il.ac.tau.eng.Utils.Logger.LogLevel;

import java.io.IOException;

import com.NoiseTrackerApp.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class NoiseTrackerActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    String methodName = "NoiseTrackerActivity.onCreate";

	    try {
			Logger.initLogger();
		} catch (IOException e) {
			Log.e("NoiseTrackerService.onStartCommand", "Logger was not created! Details: " + e.getMessage());
		}
		
		Logger.SysAppend(LogLevel.INFO, ">>>", methodName);

		Toast.makeText(this, "Noise Tracker is working...", Toast.LENGTH_SHORT).show();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		Logger.SysAppend(LogLevel.DEBUG, "NoiseTrackerActivity is now working...", methodName);
		Logger.SysAppend(LogLevel.DEBUG, "Sendind an Intent to start the NoiseTrackerService...", methodName);
		
		Intent intent = new Intent(this, NoiseTrackerService.class);
		startService(intent);
		
		Logger.SysAppend(LogLevel.INFO, "<<<\n", methodName);
	}
	
	@Override
	public void onDestroy() {
		String methodName = "NoiseTrackerActivity.onDestroy";
		Logger.SysAppend(LogLevel.INFO, ">>> " + methodName, methodName);
		
		super.onDestroy();
		Logger.SysAppend(LogLevel.INFO, "<<<\n" + methodName, methodName);
	}
}