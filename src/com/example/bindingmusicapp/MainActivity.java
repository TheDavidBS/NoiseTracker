package com.example.bindingmusicapp;
import com.example.tools.Logger;
import com.example.tools.Logger.LogLevel;
import java.io.IOException;
import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		String methodName = "MainActivity.onCreate";

	    try {
			Logger.initLogger();
		} catch (IOException e) {
			Log.e("MainActivity.onStartCommand", "Logger was not created! Details: " + e.getMessage());
		}
		
		Logger.SysAppend(LogLevel.INFO, ">>>", methodName);
		Logger.SysAppend(LogLevel.DEBUG, "MainActivity is now working...", methodName);
		
		Toast.makeText(this, "MainActivity is working...", Toast.LENGTH_SHORT).show();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// TODO: Debug: remove after testing
		printRunningServices();
		
		// starting out tracking service
		Logger.SysAppend(LogLevel.DEBUG, "Sendind an Intent to start the MainService...", methodName);
		Intent intent = new Intent(this, MainService.class);
		startService(intent);
		
		Logger.SysAppend(LogLevel.INFO, "<<<\n", methodName);
	}
	

	
	@Override
	public void onDestroy() {
		String methodName = "MainActivity.onDestroy";
		Logger.SysAppend(LogLevel.INFO, ">>> " + methodName, methodName);
		
		super.onDestroy();
		
		Logger.SysAppend(LogLevel.INFO, "<<<\n" + methodName, methodName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	
	// TODO: Debug method
	private void printRunningServices() {
	    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	    	Log.i("Service: ", service.service.getClassName());
	    }
	}

}
