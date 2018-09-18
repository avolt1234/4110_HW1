package com.example.alexpc.a4110_hw1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button;
    EditText tEdit;
    TextView tEdit2;
    String textS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tEdit = (EditText)findViewById(R.id.Texts);
        tEdit2 = (TextView)findViewById(R.id.colorInfo);

        button = (Button) findViewById(R.id.Scribbles);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    public void colorPush(View view) {
        textS = tEdit.getText().toString();
        String newColors = chooseColor();

        tEdit.setTextColor(Color.parseColor(newColors));
    }

    public String chooseColor() {
        String[] colors = new String[3];

        int[] colors2 = new int[3];

        for(int i = 1; i < 4; i++) {
            Random random = new Random();
            int Random = random.nextInt(225);
            colors2[i - 1] = Random;
            if (Random < 16){
                String newRandom = String.format("%02x", Random);
                colors[i - 1] = newRandom;
            } else {
                colors[i - 1] = Integer.toHexString(Random);
            }
        }

        String newString = TextUtils.join(", ", colors);
        String newString1 = newString.replace(", ", "");
        String finalString = "#" + newString1;

        changeColorText(colors2, finalString);

        return finalString;
    }

    public void changeColorText(int[] colors2, String hexNum) {
        String rgb = "COLOR:" + Integer.toString(colors2[0]) + "r, " + Integer.toString(colors2[1]) + "g, " + Integer.toString(colors2[2]) + "b, " + hexNum;
        tEdit2.setGravity(Gravity.CENTER);
        tEdit2.setText(rgb);
    }
}
