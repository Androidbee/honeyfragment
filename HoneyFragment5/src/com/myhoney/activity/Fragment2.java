package com.myhoney.activity;

import com.myhoney.activity.Fragment1.HoneyMessage;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {
    
    private HoneyMessage listener;

    void setHoneyListener(HoneyMessage msg) {
        this.listener = msg;
    }
    
    TextView msg_board;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        msg_board = (TextView)view.findViewById( R.id.msg_board);
        Button btn_getmsg = (Button)view.findViewById(R.id.btn_getmsg);
        btn_getmsg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
        return view;
    }
    
    void setMessage(CharSequence msg) {
        msg_board.setText(msg);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
