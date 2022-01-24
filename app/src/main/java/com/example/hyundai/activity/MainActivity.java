package com.example.hyundai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hyundai.Scanner.DWUtilities;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    final TextView output = findViewById(R.id.txtOutput);
    private ArrayList<String> arrayKode = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DWUtilities.CreateDWProfile(this);

        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setText(output.getText());
                arrayKode = new ArrayList<>();
            }
        });

        onBackPressed();
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        String a = displayScanResult(intent);
        arrayKode.add(a);
        output.setText(arrayKode.get(0));
    }

    private String displayScanResult(Intent scanIntent)
    {
        String decodedData = scanIntent.getStringExtra(getResources().getString(R.string.datawedge_intent_key_data));
        String scan = decodedData;
        return scan;
    }

    private void compare(){
        if(arrayKode.get(1).compareTo(arrayKode.get(2))==0){
            showNotifGood();
        }else{
            showNotifNotGood();{

            }
        }
    }

    private void showNotifNotGood() {
        notif_ng cdd = new notif_ng(MainActivity.this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
        cdd.setCanceledOnTouchOutside(false);
    }

    private void showNotifGood() {
        notif_good cdd = new notif_good(MainActivity.this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
        cdd.setCanceledOnTouchOutside(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}