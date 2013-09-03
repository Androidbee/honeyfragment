package com.myhoney.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.myhoney.activity.Fragment1.HoneyMessage;
import com.myhoney.activity.Fragment1.MyImage;

public class HoneyActivity extends FragmentActivity implements HoneyMessage {

    String tag = "mytag";
    Fragment1 fragment1;
    Fragment2 fragment2;
    
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if(getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT ) {
            fragment1 = (Fragment1)getSupportFragmentManager().findFragmentById(R.id.fragment1);
        } else {

            fragment1 = (Fragment1)getSupportFragmentManager().findFragmentById(R.id.fragment1);
            fragment2 = (Fragment2)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        }
//        fragment1.setHoneyListener(this);
    }

   
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem mnu1 = menu.add(0, Menu.FIRST, 0, "Item 1");
        mnu1.setAlphabeticShortcut('a');
        mnu1.setIcon(R.drawable.ic_launcher);
        MenuItemCompat.setActionView(mnu1, getCurrentFocus());
 
        
        MenuItem mnu2 = menu.add(0, Menu.FIRST+1, 1, "Item 2");
        mnu2.setAlphabeticShortcut('b');
        mnu2.setIcon(R.drawable.ic_launcher);
        MenuItemCompat.setActionView(mnu2, getCurrentFocus());

        MenuItem mnu3 = menu.add(0, Menu.FIRST+2, 2, "Item 3");
        mnu3.setAlphabeticShortcut('c');
        mnu3.setIcon(R.drawable.ic_launcher);
        MenuItemCompat.setActionView(mnu3, getCurrentFocus());

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
//        case android.R.id.home:
//            Toast.makeText(this, "애플리케이션 아이콘을 선택했습니다.",
//                    Toast.LENGTH_LONG).show();
//            Intent i = new Intent(this, HoneyActivity.class);
//            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(i);
//            return true;

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
    public void sendMessage(MyImage img) {
        Fragment2 fragment2 = (Fragment2)getSupportFragmentManager().
                findFragmentById(R.id.fragment2);
        final boolean isPortrait = getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT;
        if(isPortrait) {
            Intent intent = new Intent( getBaseContext(), Fragment2Activity.class);
            intent.putExtra("img_id", img.imgRes);
            intent.putExtra("img_name", img.title);
            startActivity(intent);
        } else {
            fragment2.setMessage(img);
        }
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
