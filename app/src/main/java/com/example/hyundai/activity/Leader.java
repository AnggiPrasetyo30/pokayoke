package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.hyundai.R;

import javax.microedition.khronos.opengles.GL;

public class Leader extends AppCompatActivity {

    private String GLOCKED;
    private final static String LOCKED = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        Intent intent = getIntent();
        GLOCKED = intent.getStringExtra(LOCKED);

        //harus ditambahi method cek status_akun operator
        //sebelumnya baru tampilkan notiflocked atau tidak
        if(GLOCKED.equals(1)) {
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