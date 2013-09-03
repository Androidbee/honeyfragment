package com.myhoney.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myhoney.activity.Fragment1.HoneyMessage;
import com.myhoney.activity.Fragment1.MyImage;

public class Fragment2 extends Fragment {
    
    TextView mTitle;
    private ImageView mImageview;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        mTitle = (TextView)view.findViewById( R.id.title);
        mImageview = (ImageView)view.findViewById(R.id.imgview);

        return view;
    }
    
    void setMessage(MyImage myimg) {
        mImageview.setImageResource(myimg.imgRes);
        mTitle.setText(myimg.title);
    }
    void setMessage(CharSequence msg, int res_id) {
        mImageview.setImageResource(res_id);
        mTitle.setText(msg);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
