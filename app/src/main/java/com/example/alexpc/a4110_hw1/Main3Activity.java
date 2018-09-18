package com.example.alexpc.a4110_hw1;


import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.byox.drawview.enums.DrawingCapture;
import com.byox.drawview.views.DrawView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import yuku.ambilwarna.AmbilWarnaDialog;

import static java.lang.System.out;


public class Main3Activity extends AppCompatActivity{
    private Button button1;
    private Button colorButton;
    private Button clearButton;
    private Button saveButton;
    private DrawView mDrawView;
    ConstraintLayout myLayout;
    int DefaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mDrawView = (DrawView) findViewById(R.id.draw_view);

        button1 = (Button) findViewById(R.id.goBack);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        colorButton = (Button) findViewById(R.id.Colors);
        DefaultColor = ContextCompat.getColor(this, R.color.colorPrimary);
        colorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                OpenColorPicker(false);
            }
        });

        clearButton = (Button) findViewById(R.id.clearScreen);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearIt();
            }
        });

        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                    saveIt();
            }
        });
    }

    public void goBack() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void OpenColorPicker(boolean AlphaSupports) {
        AmbilWarnaDialog awd = new AmbilWarnaDialog(this, DefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(Main3Activity.this, "New Color Saved", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                DefaultColor = color;
                mDrawView.setDrawColor(color);
            }
        });
        awd.show();
    }

    public void clearIt(){
        mDrawView.restartDrawing();
    }

    public void saveIt() {
        Object[] saveList = mDrawView.createCapture(DrawingCapture.BITMAP);
        String dir = getFilesDir().getAbsolutePath();
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root);
        String fileName = "Image-HW1.png";
        File fileSaver = new File(myDir + "/Image-HW1.png");
        Bitmap bmp = (Bitmap) saveList[0];
        try {
            FileOutputStream fOut = new FileOutputStream(fileSaver);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            out.flush();
            out.close();
            Toast.makeText(Main3Activity.this, "Image Saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(Main3Activity.this, "Save Failure", Toast.LENGTH_SHORT).show();
        }
        int holder = 3;
    }
}
