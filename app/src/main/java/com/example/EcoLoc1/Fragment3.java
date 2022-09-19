package com.example.EcoLoc1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.EcoLoc1.db.MyDbManager;

public class Fragment3 extends Fragment {
//    private TextView TvText;
//    private MyDbManager myDbManager;
//    private EditText TitleLoc,TextLocation;

//    @Override
//    public void onStart() {
//        super.onStart();
//        myDbManager = new MyDbManager(this);
//        TvText = getActivity().findViewById(R.id.TvText);
//
//    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }
}