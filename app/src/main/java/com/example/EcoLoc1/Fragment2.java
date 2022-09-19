package com.example.EcoLoc1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.example.EcoLoc1.db.MyDbManager;

public class Fragment2 extends Fragment {
    private MyDbManager myDbManager;
    private EditText TitleLoc,TextLocation;
    private TextView TvText;
    private Button button;


    @Override
    public void onStart() {
        super.onStart();

        myDbManager = new MyDbManager(getActivity().getApplicationContext());
        TitleLoc = getActivity().findViewById(R.id.TitleLoc);
        TextLocation = getActivity().findViewById(R.id.TextLocation);
        TvText = getActivity().findViewById(R.id.TvText);
        button = getActivity().findViewById(R.id.Save);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick (View view){
                TvText.setText("");
                myDbManager.insertToDb(TitleLoc.getText().toString(), TextLocation.getText().toString());
                for (String title : myDbManager.getFromDb()) {
                    TvText.append(title);
                    TvText.append("\n");
                }
            }
    });
    }
    @Override
    public void onResume() {
        super.onResume();
        myDbManager.openDb();
        for (String title : myDbManager.getFromDb()) {
            TvText.append(title);
            TvText.append("\n");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_2, container, false);

    }

//    button.setOnClickListener(new OnClickListener() {
//        @Override
//        public void onClick (View view){
//
//            myDbManager.insertToDb(TitleLoc.getText().toString(), TextLocation.getText().toString());
//            for (String title : myDbManager.getFromDb()) {
//                TvText.append((CharSequence) TitleLoc);
//                TvText.append("\n");
//            }
//        }
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        myDbManager.closeDb();
    }
}


