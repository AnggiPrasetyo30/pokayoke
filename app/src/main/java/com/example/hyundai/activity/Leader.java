package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.hyundai.R;

import javax.microedition.khronos.opengles.GL;

public class Leader extends AppCompatActivity {

    private String GLOCKED;
    private final static String LOCKED = "0";
    private TextView nama_user;

    private final static String NPK = "npk";
    private final static String NAMA = "name";
    private final static String TRIAL = "trial";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        Intent intent = getIntent();
        nama_user = findViewById(R.id.nama_user);
        GLOCKED = intent.getStringExtra(LOCKED);
        String  Gnama = intent.getStringExtra(NAMA);
        String GNPK = intent.getStringExtra(NPK);

        Log.e("GLOCKED", "onCreate: " + GLOCKED );


        nama_user.setText(Gnama);
        //harus ditambahi method cek status_akun operator
        //sebelumnya baru tampilkan notiflocked atau tidak
        if(GLOCKED == "0") {
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