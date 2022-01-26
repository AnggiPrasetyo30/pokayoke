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

public class notif_locked extends Dialog implements  View.OnClickListener{

    public Activity c;
    public Dialog d;
    public Button next;
    TextView alasan;

    public notif_locked(Activity a) {
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
        next = findViewById(R.id.btnNext);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //isi dengan methode update status_akun operator
        dismiss();
    }

    @Override
    public void onBackPressed() {    }
}
