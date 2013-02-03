package il.ac.tau.eng.NoiseTracker;
import il.ac.tau.eng.Utils.Logger;
import il.ac.tau.eng.Utils.Logger.LogLevel;

import java.io.IOException;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OnBootBroadcastReceiver extends BroadcastReceiver  {
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		 try {
				Logger.initLogger();
			} catch (IOException e) {
				Log.e("NoiseTrackerService.onStartCommand", "Logger was not created! Details: " + e.getMessage());
			}
			
			Logger.SysAppend(LogLevel.INFO, "!!!", "Service loaded at start" );
		Intent serviceLauncher = new Intent(context, NoiseTrackerService.class);		
		context.startService(serviceLauncher);
		Log.d("TEST", "Service loaded at start");
		
		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) || intent.getAction().equals(Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE)) {
			Log.d("TEST", "Passed if");
			Logger.SysAppend(LogLevel.INFO, "!!!", "Passed the if" );
		}
	}
}