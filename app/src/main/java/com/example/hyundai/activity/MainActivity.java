package com.example.hyundai.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.hyundai.SQLite.shopping;
import com.example.hyundai.Scanner.DWUtilities;
import com.example.hyundai.SQLite.DatabaseHelper;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    TextView output;
<<<<<<< HEAD
    private ArrayList<String> arrayKode = new ArrayList<String>();
    String pn_api, pn_cust, data_api, data_cust, customer;
    int hasilScan;

    private String GNPK;
    private String GTRIAL;

=======

    //variabel yang akan diinput kedalam tabel result
    String pn_api, pn_cust, customer;
    String data_api = null;
    String data_cust = null;

    //untuk menghitung sudah berapa kali scan
    int hasilScan;

    //untuk menampung value dari intent
    private String GNPK;
    private String GTRIAL;

    //nama string yang dilempar pada intent
>>>>>>> 41d14a5 (27-01-2022)
    private final static String NPK = "npk";
    private final static String TRIAL = "trial";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DWUtilities.CreateDWProfile(this);
        mDatabaseHelper = new DatabaseHelper(this);

        Intent intent2 = getIntent();
        GNPK = intent2.getStringExtra(NPK);
        GTRIAL = intent2.getStringExtra(TRIAL);

        hasilScan = 0;

        output = findViewById(R.id.kodekanban);
        Button btnReset = findViewById(R.id.btnReset);


        btnReset.setOnClickListener(view -> {
            output.setText(R.string.kode_kanban);
            hasilScan = 0;
            pn_cust = null;
            pn_api = null;
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String a = displayScanResult(intent);
        String npk = GNPK;
        String trial = GTRIAL;


        if (a.length() == 32) {
            data_cust = a;
            String kanban = GetSubstrCustBack(a);
            output.setText(kanban);
            pn_cust = kanban;
            hasilScan++;
        } else if (a.length() == 29) {
            data_cust = a;
            String kanban = GetSubstrCustFront(a);
            output.setText(kanban);
            pn_cust = kanban;
            hasilScan++;
        } else {
            data_api = a;
            String kanban = GetSubstrApi(a);
            if (mDatabaseHelper.CekKanbanAPI(kanban) != null) {
                pn_api = mDatabaseHelper.CekKanbanAPI(kanban);
                customer = mDatabaseHelper.CekCustomer(kanban);
                output.setText(pn_api);
                hasilScan++;
            } else {
                showNotifNotGood(); // alasan : data tidak ditemukan
            }
        }

<<<<<<< HEAD
        if (hasilScan>1) {
            if (pn_cust.contains(pn_api)) {
                showNotifGood();
<<<<<<< HEAD
                mDatabaseHelper.InsertResult(new shopping(npk, customer, pn_api, pn_cust,
                        "OK", String.valueOf(Calendar.getInstance().getTime()), data_api,
                        data_cust, trial  ));
=======
                mDatabaseHelper.InsertResult(new shopping(
                        "1503",
                        "Hyundai",
                         pn_api, pn_cust,
                        "OK",
                         String.valueOf(Calendar.getInstance().getTime()),
                         data_api,
                         data_cust,
                        "T"));
>>>>>>> e1340205e5c577415e70ca49e7aa8d66f4e4ac55
                hasilScan = 0;
                output.setText(R.string.kode_kanban);
            } else {
                showNotifNotGood();
                arrayKode.clear();
            }
        }else {
                if (pn_api.equals(pn_api)) {
                    showNotifNotGood();
                }
=======
        if(pn_api!=null) {
            if (!mDatabaseHelper.cekOnResult(data_api)) {

                    mDatabaseHelper.InsertResult(new shopping(npk, customer, pn_api, pn_cust,
                        "Double", String.valueOf(Calendar.getInstance().getTime()), data_api, data_cust, trial));

                    showNotifNotGood();
                    pn_api=null;
                    hasilScan = 0;
            } else if (hasilScan > 1) {
                if (pn_cust.contains(pn_api)) {
                    showNotifGood();
                    mDatabaseHelper.InsertResult(new shopping(npk, customer, pn_api, pn_cust,
                            "OK", String.valueOf(Calendar.getInstance().getTime()), data_api, data_cust, trial));
                    pn_api=null;
                    hasilScan = 0;
                    output.setText(R.string.kode_kanban);
                } else {
                    mDatabaseHelper.InsertResult(new shopping(npk, customer, pn_api, pn_cust,
                            "NG", String.valueOf(Calendar.getInstance().getTime()), data_api, data_cust, trial));
                    pn_api=null;
                    showNotifNotGood();
                    hasilScan = 0;
                }
            }
>>>>>>> 41d14a5 (27-01-2022)
        }
    }

    private String displayScanResult(Intent scanIntent) {
        String decodedData = scanIntent.getStringExtra(getResources()
                .getString(R.string.datawedge_intent_key_data));
        return decodedData;
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

    private String GetSubstrCustBack(String kanban) {
        return kanban.substring(4, 17);
    }

    private String GetSubstrCustFront(String kanban) {
        return kanban.substring(4, 14);
    }

    private String GetSubstrApi(String kanban) {
        return kanban.substring(8, 25);
    }

}