package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.hyundai.R;

public class Leader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);

        //harus ditambahi method cek status_akun operator
        //sebelumnya baru tampilkan notiflocked atau tidak
        showNotifLocked();

    }

    private void showNotifLocked() {
        notif_locked cdd = new notif_locked(Leader.this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
        cdd.setCanceledOnTouchOutside(false);
    }
}