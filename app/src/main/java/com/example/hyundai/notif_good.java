package com.example.hyundai;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class notif_good extends Dialog implements  View.OnClickListener{

    public Activity c;
    public Dialog d;
    public Button next;

    public notif_good(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.notif_good);
        next = (Button) findViewById(R.id.btnNext);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }

}

