package com.example.cameraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void takePhoto(View view) {
        Intent intent = new Intent(this, TakePhotoActivity.class);
        startActivity(intent);
    }

    public void viewPhotos(View view) {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }
}
