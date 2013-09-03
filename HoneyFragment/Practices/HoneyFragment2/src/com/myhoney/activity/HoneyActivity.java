package com.myhoney.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class HoneyActivity extends Activity {

    String tag = "mytag";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(tag, "onCreate()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "HoneyActivity: onDestroy()");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "HoneyActivity: onPause()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "HoneyActivity: onRestart()");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "HoneyActivity: onResume()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "HoneyActivity: onStart()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "HoneyActivity: onStop()");
    }
}