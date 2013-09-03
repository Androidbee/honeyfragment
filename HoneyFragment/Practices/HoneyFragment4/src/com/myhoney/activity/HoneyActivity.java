package com.myhoney.activity;

import com.myhoney.activity.Fragment1.HoneyMessage;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class HoneyActivity extends Activity implements HoneyMessage {

    String tag = "mytag";
    Fragment1 fragment1;
    Fragment2 fragment2;
    
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(tag, "onCreate()");
        
        fragment1 = (Fragment1)getFragmentManager()
                .findFragmentById(R.id.fragment1);
        fragment2 = (Fragment2)getFragmentManager()
                .findFragmentById(R.id.fragment2);
        
        fragment1.setHoneyListener(this);
        fragment2.setHoneyListener(this);

    }


    @Override
    public void sendMessage(CharSequence msg) {
        fragment2.setMessage(msg);
    }

    @Override
    public String getNextMessage() {
        return null;
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy() 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause() 호출");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart() 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume() 호출");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart() 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "onStop() 호출");
    }

}