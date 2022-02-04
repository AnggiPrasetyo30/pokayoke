package com.example.hyundai.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.hyundai.R;

import static android.content.Context.MODE_PRIVATE;

public class notif_ng extends Dialog implements  View.OnClickListener{

    public Activity c;
    public Dialog d;
    public Button next;
    MediaPlayer mp;
    TextView alasan;

    //SharedPreferences
    SharedPreferences mSharedPreferences;
    private final static String APP_NAME = "Hyundai";
    private final static String LOCKED = "0";

    public notif_ng(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.notif_ng);

        mp = MainActivity.mp;

        //SharedPreferences
        mSharedPreferences = getContext().getSharedPreferences(APP_NAME, MODE_PRIVATE);


        alasan = findViewById(R.id.reason);
        alasan.setText(MainActivity.alasan_NG);
        next = findViewById(R.id.btnNext);
        mp = MainActivity.mp;
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // ganti dengan fungsi logout + intent ke halaman login

        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putString(LOCKED, "1");
        edit.apply();
        mp.stop();


        mp.stop();

        Intent intent = new Intent(getContext(), Login.class );
        Log.e("LOCKED", "onCreate: " + LOCKED );
        c.startActivity(intent);
    }

    @Override
    public void onBackPressed() {    }
}