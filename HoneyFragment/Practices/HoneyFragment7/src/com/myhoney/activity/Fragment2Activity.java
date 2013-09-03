package com.myhoney.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.myhoney.activity.Fragment1.MyImage;

public class Fragment2Activity extends FragmentActivity {

    String tag = "my_events";
    Fragment2 fragment2;
    
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        if (getResources().getConfiguration().orientation == 
                Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.main_fragment2);

        Intent intent = getIntent();
        int img_id = intent.getIntExtra("img_id", R.drawable.ic_launcher);
        CharSequence msg = intent.getCharSequenceExtra("img_name");
        
        fragment2 = (Fragment2) getSupportFragmentManager()
                .findFragmentById(R.id.fragment2);
        fragment2.setMessage(msg, img_id );
        
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "onStop()");
    }

}