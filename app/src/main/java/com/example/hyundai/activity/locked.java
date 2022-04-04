package com.example.hyundai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hyundai.R;

public class locked extends AppCompatActivity {
    TextView Result;
    public Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locked);
        Result = findViewById(R.id.text5);
        Result.setText(MainActivity.alasan_NG);
        next = findViewById(R.id.btnScan);
        Log.e("Alasan", "onCreate: "+MainActivity.alasan_NG );

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(locked.this, Login.class);
                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {    }
}