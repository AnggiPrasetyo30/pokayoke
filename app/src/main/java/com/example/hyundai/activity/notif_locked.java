package com.example.hyundai.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.DirectAction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.hyundai.R;

import static android.content.Context.MODE_PRIVATE;

public class notif_locked extends Dialog implements  View.OnClickListener{

    public Activity c;
    public Dialog d;
    public Button next;
    TextView alasan;
    MainActivity mMainActivity ;

    SharedPreferences mSharedPreferences;
    private final static String APP_NAME= "Hyundai";
    private final static String LOCKED = "0";

    public notif_locked(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.notif_locked);
            next = findViewById(R.id.btnNext);
            next.setOnClickListener(this);

        mSharedPreferences = getContext().getSharedPreferences(APP_NAME, MODE_PRIVATE);
        String GLOCKED = mSharedPreferences.getString(LOCKED, null);
        Log.e("GLOCKED", "onCreate: " + GLOCKED );
    }

    @Override
    public void onClick(View v) {
        //isi dengan methode update status_akun operator
        dismiss();
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putString(LOCKED, "0");
        edit.apply();
        Log.e("LOCKED", "onCreate: " + LOCKED );
    }

    @Override
    public void onBackPressed() {    }

}
