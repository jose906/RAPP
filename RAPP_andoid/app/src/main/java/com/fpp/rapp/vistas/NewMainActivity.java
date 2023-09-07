package com.fpp.rapp.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fpp.rapp.R;

public class NewMainActivity extends AppCompatActivity {

    ImageView info1, info2,info3,info4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);

    }
}