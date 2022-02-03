package com.example.hyundai.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.hyundai.R;

public class locked extends AppCompatActivity {

    TextView alasan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locked);

        alasan = findViewById(R.id.text5);
        alasan.setText(MainActivity.alasan_NG);
    }

    public void onBackPressed() {    }
}