package com.myhoney.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {
	private String tag = "my_events";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d( tag, "fragment1: onCreateView()");
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment1, container, false);
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
	public void onActivityCreated(Bundle savedInstanceState) { 
		super.onActivityCreated(savedInstanceState);
		Log.d( tag, "fragment1: onActivityCreated()");
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
}
