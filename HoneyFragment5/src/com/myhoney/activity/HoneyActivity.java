package com.myhoney.activity;

import com.myhoney.activity.Fragment1.HoneyMessage;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
        
        
        ActionBar actionBar = getActionBar();
        // actionBar.hide();
        actionBar.show();

    }
    @Override
    public void sendMessage(CharSequence msg) {
        fragment2.setMessage(msg);
    }

    @Override
    public String getNextMessage() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem mnu1 = menu.add(0, Menu.FIRST, 0, "Item 1");
        mnu1.setAlphabeticShortcut('a');
        mnu1.setIcon(R.drawable.ic_launcher);
        mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        
        MenuItem mnu2 = menu.add(0, Menu.FIRST+1, 1, "Item 2");
        mnu2.setAlphabeticShortcut('b');
        mnu2.setIcon(R.drawable.ic_launcher);
        mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        MenuItem mnu3 = menu.add(0, Menu.FIRST+2, 2, "Item 3");
        mnu3.setAlphabeticShortcut('c');
        mnu3.setIcon(R.drawable.ic_launcher);
        mnu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        MenuItem mnu4 = menu.add(0, Menu.FIRST+3, 3, "Item 4");
        mnu4.setAlphabeticShortcut('d');

//        menu.add(0, 3, 3, "Item 5");
//        menu.add(0, 3, 3, "Item 6");
//        menu.add(0, 3, 3, "Item 7");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            Toast.makeText(this, "애플리케이션 아이콘을 선택했습니다.",
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, HoneyActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            return true;

        case Menu.FIRST:
            Toast.makeText(this, "메뉴 Item1", Toast.LENGTH_LONG)
                    .show();
            return true;

        case Menu.FIRST+1:
            Toast.makeText(this, "메뉴 Item2", Toast.LENGTH_LONG)
                    .show();
            return true;

        case Menu.FIRST+2:
            Toast.makeText(this, "메뉴 Item3", Toast.LENGTH_LONG)
                    .show();
            return true;

        case Menu.FIRST+3:
            Toast.makeText(this, "메뉴 Item4", Toast.LENGTH_LONG)
                    .show();
            return true;

        }
        return false;
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