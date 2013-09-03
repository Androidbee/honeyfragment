package com.myhoney.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button btnGetText = (Button) getActivity().findViewById(
                R.id.btn_gettext);
        btnGetText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView txtFragment1 = (TextView) getActivity().findViewById(
                        R.id.txt_fragment1);
                Toast.makeText(getActivity(), txtFragment1.getText(), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
