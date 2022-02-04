package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hyundai.R;
import com.example.hyundai.SQLite.DatabaseHelper;

public class create_product extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    Spinner Station_Num, Position, Goods, Line_Prod;
    EditText SKU, PartName, PNApi, PNCust, PTLOC, SFWGH, FGWH, NKIWH, Type, Customer, CustId, SupplierId, JobNum, Address, TimeProd, QTYPack, QTYChild, SeqQR, SeqDataPart;
    Button Simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

        mDatabaseHelper = new DatabaseHelper(this);
        Station_Num = (Spinner) findViewById(R.id.fieldStationNumber);
        SKU = (EditText) findViewById(R.id.fieldSKU);
        PartName = (EditText) findViewById(R.id.fieldPartName);
        Position = (Spinner) findViewById(R.id.fieldPosition);
        PNApi = (EditText) findViewById(R.id.fieldPartNumberAPI);
        PNCust = (EditText) findViewById(R.id.fieldPartNumberCust);
        PTLOC = (EditText) findViewById(R.id.fieldPtloc);
        SFWGH = (EditText) findViewById(R.id.fieldSfgwh);
        NKIWH = (EditText) findViewById(R.id.fieldNkiwh);
        FGWH = (EditText) findViewById(R.id.fieldFgwh);
        Type = (EditText) findViewById(R.id.fieldtype);
        Customer = (EditText) findViewById(R.id.fieldCustomer);
        CustId = (EditText) findViewById(R.id.fieldCustomerId);
        SupplierId = (EditText) findViewById(R.id.fieldSupplierId);
        JobNum = (EditText) findViewById(R.id.fieldJobNumber);
        Address = (EditText) findViewById(R.id.fieldAddress);
        TimeProd = (EditText) findViewById(R.id.fieldTimeProduction);
        QTYPack = (EditText) findViewById(R.id.fieldQuantityPackaging);
        QTYChild = (EditText) findViewById(R.id.fieldQuantityChild);
        Goods = (Spinner) findViewById(R.id.fieldGoods);
        Line_Prod = (Spinner) findViewById(R.id.fieldLineProd);
        SeqQR = (EditText) findViewById(R.id.fieldSequenceQR);
        SeqDataPart = (EditText) findViewById(R.id.fieldSequenceDataPart);
        Simpan = (Button) findViewById(R.id.btnBuat);

        final Spinner ListStation = Station_Num;
        final Spinner ListPosition = Position;
        final Spinner ListGoods = Goods;
        final Spinner LineProd = Line_Prod;

        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
                db.execSQL("insert into product(station_num, sku, part_name, position, pn_api, pn_cust, ptloc, sfgwh, fgwh, nkiwh, type, customer, cust_id, supplier_id, job_num, address, time_production, qty_packaging, qty_child, goods, line_prod, seq_qr, seq_data_part, TRIAL853) values('" +
                        ListStation.getSelectedItem().toString() + "','" + SKU.getText().toString() + "','" + PartName.getText().toString() + "','" +
                        ListPosition.getSelectedItem().toString() + "','" + PNApi.getText().toString() + "','" + PNCust.getText().toString() + "','" +
                        PTLOC.getText().toString() + "','" + SFWGH.getText().toString() + "','" + FGWH.getText().toString() + "','" + NKIWH.getText().toString() + "','" +
                        Type.getText().toString() + "','" + Customer.getText().toString() + "','" + CustId.getText().toString() + "','" + SupplierId.getText().toString() + "','" +
                        JobNum.getText().toString() + "','" + Address.getText().toString() + "','" + TimeProd.getText().toString() + "','" + QTYPack.getText().toString() + "','" +
                        QTYChild.getText().toString() + "','" + ListGoods.getSelectedItem().toString() + "','" + LineProd.getSelectedItem().toString() + "','" + SeqQR.getText().toString() + "','" +
                        SeqDataPart.getText().toString() + "','" + "T" + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}