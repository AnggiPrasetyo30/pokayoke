package com.example.hyundai.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hyundai.R;
import com.example.hyundai.Scanner.DWUtilities;
import com.example.hyundai.SQLite.DatabaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView output;
    private ArrayList<String> arrayKode = new ArrayList<String>();
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DWUtilities.CreateDWProfile(this);
        DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);

        output = findViewById(R.id.kodekanban);
        Button btnReset = findViewById(R.id.btnReset);


        btnReset.setOnClickListener(view -> {
            output.setText(R.string.kode_kanban);
            arrayKode = new ArrayList<>();
        });

    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);

        String kanban = null;

        String a = displayScanResult(intent);

        if (a.length()>25){
            kanban = GetSubstrCust(a);
            Toast.makeText(this, kanban, Toast.LENGTH_SHORT).show();
            if (!mDatabaseHelper.CekKanbanCust(kanban)) {
                showNotifNotGood();
            } else {
                addToArray(arrayKode, kanban);
            }
        }else {
            if(mDatabaseHelper.CekKanbanAPI(a)!=null) {
                Log.e("pn_cust","CekKanbanAPI: "+ kanban);
                kanban = mDatabaseHelper.CekKanbanAPI(a);
                addToArray(arrayKode, kanban);
            }else{
                showNotifNotGood();
            }
        }

        arrayKode.add(kanban);
        output.setText(arrayKode.get(0));

        if(arrayKode.size()>1){
            compare();
        }
    }

    private String displayScanResult(Intent scanIntent)
    {
        String decodedData = scanIntent.getStringExtra(getResources().getString(R.string.datawedge_intent_key_data));
        return decodedData;
    }

    private void compare(){
        if(arrayKode.get(0).compareTo(arrayKode.get(1))==0){
            showNotifGood();
            arrayKode = new ArrayList<>();
            output.setText(R.string.kode_kanban);
        }else{
            showNotifNotGood();{
            }
        }
    }

    private void showNotifNotGood() {
        notif_ng cdd = new notif_ng(MainActivity.this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
        cdd.setCanceledOnTouchOutside(false);
    }

    private void showNotifGood() {
        notif_good cdd = new notif_good(MainActivity.this);
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
        cdd.setCanceledOnTouchOutside(false);
    }

    private String GetSubstrCust(String kanban){
        String substring = kanban.substring(4, 17);
        return substring;
    }

    private void addToArray(ArrayList arrayList, String input){
        arrayList.add(input);
    }
}