package com.example.hyundai.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.hyundai.R;

public class notif_ng extends Dialog implements  View.OnClickListener{

    public Activity c;
    public Dialog d;
    public Button next;
    TextView alasan;

    public notif_ng(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.notif_ng);

        alasan = findViewById(R.id.reason);
        alasan.setText(MainActivity.alasan_NG);
        next = findViewById(R.id.btnNext);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // ganti dengan fungsi logout + intent ke halaman login

        Intent intent = new Intent(getContext(), Login.class );
        c.finish();
        c.isDestroyed();
        c.isFinishing();
        c.startActivity(intent);
    }

    @Override
    public void onBackPressed() {    }
}

