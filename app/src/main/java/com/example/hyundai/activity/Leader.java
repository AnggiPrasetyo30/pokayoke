package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hyundai.R;

import javax.microedition.khronos.opengles.GL;

public class Leader extends AppCompatActivity {

    private TextView nama_user;

    private final static String NPK = "npk";
    private final static String NAMA = "name";
    private final static String TRIAL = "trial";

    SharedPreferences mSharedPreferences;
    private final static String APP_NAME= "Hyundai";
    private final static String LOCKED = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        Intent intent = getIntent();
        nama_user = findViewById(R.id.nama_user);
        String  Gnama = intent.getStringExtra(NAMA);
        String GNPK = intent.getStringExtra(NPK);

        mSharedPreferences = getSharedPreferences(APP_NAME, MODE_PRIVATE);
        String GLOCKED = mSharedPreferences.getString(LOCKED, null);
        Log.e("GLOCKED", "onCreate: " + GLOCKED );


        nama_user.setText(Gnama);
        //harus ditambahi method cek status_akun operator
        //sebelumnya baru tampilkan notiflocked atau tidak
        if(GLOCKED.equals("1")) {
            showNotifLocked();
        }
    }


    private void showNotifLocked() {
        notif_locked cdd = new notif_locked(Leader.this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
        cdd.setCanceledOnTouchOutside(false);
    }
}