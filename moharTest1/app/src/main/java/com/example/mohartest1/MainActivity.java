package com.example.mohartest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = (ImageView)findViewById(R.id.img_loading);
        final AnimationDrawable drawable = (AnimationDrawable) iv.getBackground();
        drawable.start();
    }

    public void  toStartPage(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}