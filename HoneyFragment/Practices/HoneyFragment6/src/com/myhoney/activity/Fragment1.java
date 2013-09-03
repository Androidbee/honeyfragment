package com.myhoney.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment1 extends ListFragment {
    
    private String tag = "mytag";
    int[] myImages = {
            R.drawable.dokdo_1_17, R.drawable.dokdo_1_20,
            R.drawable.dokdo_2_05, R.drawable.dokdo_3_01
    };

    @Override
    public void onActivityCreated(Bundle savedInstanceState) { 
        super.onActivityCreated(savedInstanceState);
        Log.d( tag, "fragment1: onActivityCreated()");
        
        setListAdapter( ArrayAdapter.createFromResource(getActivity(),
                R.array.title_list, 
                android.R.layout.simple_list_item_1));
        
    }
    
    
    
	@Override
    public void onListItemClick(ListView l, View v, int position, long id) {
//	    listener.sendMessage(((Button)v).getText());
	    listener.sendMessage( new MyImage( ((TextView)v).getText(), myImages[position]));
    }



    @Override
	public void onAttach(Activity activity) { 
		super.onAttach(activity); 
		Log.d( tag, "fragment1: onAttach()");
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		Log.d( tag, "fragment1: onCreate()");
	}

	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(tag, "fragment1: onDestroy()");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.d( tag, "fragment1: onDestroyView");
	}

	@Override
	public void onDetach() { 
		super.onDetach(); 
		Log.d( tag, "fragment1: onDetach");
	}
	@Override
	public void onPause() {
		super.onPause();
		Log.d(tag, "fragment1: onPause()");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(tag, "fragment1: onResume()");
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d(tag, "fragment1: onStart()");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d(tag, "fragment1: onStop()");
	}

//	public void onRestart() {
//		super.onRestart();
//		Log.d(tag, "onRestart()");
//	}
	

    
    interface HoneyMessage {
        void sendMessage(MyImage myimg);
    }
    private HoneyMessage listener;

    void setHoneyListener(HoneyMessage msg) {
        this.listener = msg;
    }
    
    class MyImage {
        int imgRes;
        String title;
        public MyImage(CharSequence str, int res) {
            this.imgRes = res;
            this.title = str.toString();
        }
    }
    
//    OnClickListener btnListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            listener.sendMessage(((Button)v).getText());
//        }
//    };
}
