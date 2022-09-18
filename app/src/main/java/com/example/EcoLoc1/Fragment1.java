package com.example.EcoLoc1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

//    public static class Fragment extends AppCompatActivity {

        private Button button;
        private ImageView imageView;

//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.fragment_1);
//
//            imageView = findViewById(R.id.capturedImage);
//            button = findViewById(R.id.Photo);
            @Override
            public void onStart() {
            super.onStart();

            imageView = getActivity().findViewById(R.id.capturedImage);
            button = getActivity().findViewById(R.id.Photo);


            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(open_camera, 100);
                }
            });

        }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(photo);
    }


    }

