package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hyundai.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Leader extends AppCompatActivity {

    FloatingActionButton fab, fab1,fab2, fab3;
    Animation openAnim, closeAnim, toBottom, fromBottom;
    TextView txtuser, txtproduct, txtriwayat;

    boolean isOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab1 = (FloatingActionButton) findViewById(R.id.floatingActionButton1);
        fab2 = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        fab3 = (FloatingActionButton) findViewById(R.id.floatingActionButton3);

        txtuser = findViewById(R.id.txtUser);
        txtproduct = findViewById(R.id.product);
        txtriwayat = findViewById(R.id.riwayat);

        openAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_open);
        closeAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_close);

        toBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.to_botoom);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                animationFab();
            }
        });

        fab1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                animationFab();
                Toast.makeText(Leader.this, "berhasil", Toast.LENGTH_SHORT).show();
            }
        });

        fab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                animationFab();
                Toast.makeText(Leader.this, "berhasil", Toast.LENGTH_SHORT).show();

            }
        });

        fab3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                animationFab();
                Toast.makeText(Leader.this, "berhasil", Toast.LENGTH_SHORT).show();

            }
        });




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

    private void animationFab(){
        if(isOpen){
            fab.startAnimation(fromBottom);
            fab1.startAnimation(closeAnim); fab1.setClickable(false);
            fab2.startAnimation(closeAnim); fab2.setClickable(false);
            fab3.startAnimation(closeAnim); fab3.setClickable(false);

            txtuser.startAnimation(closeAnim);
            txtproduct.startAnimation(closeAnim);
            txtriwayat.startAnimation(closeAnim);
            isOpen=false;
        }
        else{
            fab.startAnimation(toBottom);
            fab1.startAnimation(openAnim); fab1.setClickable(true);
            fab2.startAnimation(openAnim); fab2.setClickable(true);
            fab3.startAnimation(openAnim); fab3.setClickable(true);

            txtuser.startAnimation(openAnim);
            txtproduct.startAnimation(openAnim);
            txtriwayat.startAnimation(openAnim);
            isOpen=true;
        }
    }
}