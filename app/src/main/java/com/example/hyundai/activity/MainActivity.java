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

    DatabaseHelper mDatabaseHelper;
    TextView output;
    private ArrayList<String> arrayKode = new ArrayList<String>();
    String pn_api, pn_hyundai;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DWUtilities.CreateDWProfile(this);
        mDatabaseHelper = new DatabaseHelper(this);

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
        String a = displayScanResult(intent);

        if (a.length() == 32){
            String kanban = GetSubstrCustBack(a);
            output.setText(kanban);
            addToArray(arrayKode, kanban);
        } else if (a.length() == 29 ) {
            String kanban = GetSubstrCustFront(a);
            output.setText(kanban);
            addToArray(arrayKode, kanban);
        }
        else
        {
            String kanban = GetSubstrApi(a);
            if(mDatabaseHelper.CekKanbanAPI(kanban) != null) {
                pn_api = mDatabaseHelper.CekKanbanAPI(kanban);
                output.setText(pn_api);
                addToArray(arrayKode, mDatabaseHelper.CekKanbanAPI(kanban));
            }else{
                showNotifNotGood(); // alasan : data tidak ditemukan
            }
        }
        if (arrayKode.size()>1) {
            if (arrayKode.get(0).contains(arrayKode.get(1))) {
                showNotifGood();
            } else {
                showNotifNotGood();
            }
        }else {

        }

        /*if(arrayKode.size()>1){
            compare();
        }*/
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

    private String GetSubstrCustBack(String kanban){
        return kanban.substring(4, 17);
    }

    private String GetSubstrCustFront(String kanban){
        return kanban.substring(4, 14);
    }

    private String GetSubstrApi(String kanban){
        return kanban.substring(8, 25);
    }

    /*private Boolean CekKonten (String a, String b){
        return a.contains(b);
    }*/

    private void addToArray(ArrayList arrayList, String input){
        arrayList.add(input);
    }
}