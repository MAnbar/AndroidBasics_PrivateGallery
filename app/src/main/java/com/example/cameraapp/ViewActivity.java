package com.example.cameraapp;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.cameraapp.adapters.ImageAdapter;

import java.io.File;

public class ViewActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.camera.MESSAGE";
    ImageAdapter imageAdapter;
    File[] files;

    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        GridView gridview = (GridView) findViewById(R.id.grid_view);
        imageAdapter = new ImageAdapter(this);
        gridview.setAdapter(imageAdapter);

        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        String targetPath=storageDir.getAbsolutePath();

        files = storageDir.listFiles();
        for (File file : files){
            imageAdapter.add(file.getAbsolutePath());
        }

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {


                Intent intent = new Intent(getApplicationContext(), ViewImageActivity.class);
                String message = files[position].getAbsolutePath();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);

            }
        });
    }
}
