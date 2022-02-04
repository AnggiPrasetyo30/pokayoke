package com.example.hyundai;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hyundai.SQLite.DatabaseHelper;

import java.util.Calendar;

public class update_product extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper mDatabaseHelper;
    EditText sku, part_name, part_number_api, part_number_cust,
            ptloc, sfgwh, fgwh, nkiwh, type, customer, customer_id, supplier_id,
            job_number, address, time_production, quantity_packaging,
            quantity_child, sequence_qr, sequence_data_part;
    Spinner station_number, position, goods, line_production;
    Button Simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        mDatabaseHelper = new DatabaseHelper(this);
        sku = (EditText) findViewById(R.id.fieldSKU);
        part_name = (EditText) findViewById(R.id.fieldPartName);
        part_number_api = (EditText)findViewById(R.id.fieldPartNumberAPI);
        part_number_cust= (EditText) findViewById(R.id.fieldPartNumberCust);
        ptloc = (EditText) findViewById(R.id.fieldPtloc);
        sfgwh = (EditText)findViewById(R.id.fieldSfgwh);
        fgwh = (EditText) findViewById(R.id.fieldFgwh);
        nkiwh = (EditText) findViewById(R.id.fieldNkiwh);
        type = (EditText)findViewById(R.id.fieldtype);
        customer= (EditText) findViewById(R.id.fieldCustomer);
        customer_id = (EditText) findViewById(R.id.fieldCustomerId);
        supplier_id = (EditText)findViewById(R.id.fieldSupplierId);
        job_number = (EditText)findViewById(R.id.fieldJobNumber);
        address= (EditText) findViewById(R.id.fieldAddress);
        time_production = (EditText) findViewById(R.id.fieldTimeProduction);
        quantity_packaging = (EditText)findViewById(R.id.fieldQuantityPackaging);
        quantity_child = (EditText) findViewById(R.id.fieldQuantityChild);
        sequence_qr = (EditText) findViewById(R.id.fieldSequenceQR);
        sequence_data_part = (EditText)findViewById(R.id.fieldSequenceDataPart);

        station_number = (Spinner) findViewById(R.id.fieldStationNumber);
        position = (Spinner) findViewById(R.id.fieldPosition);
        goods = (Spinner) findViewById(R.id.fieldGoods);
        line_production = (Spinner) findViewById(R.id.fieldLineProd);

        Simpan = (Button) findViewById(R.id.btnBuat);

        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM product WHERE sku = '" +
                getIntent().getStringExtra("SKU") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            sku.setText(cursor.getString(2));
            part_name.setText(cursor.getString(3));
            part_number_api.setText(cursor.getString(5));
            part_number_cust.setText(cursor.getString(6));
            ptloc.setText(cursor.getString(7));
            sfgwh.setText(cursor.getString(8));
            fgwh.setText(cursor.getString(9));
            nkiwh.setText(cursor.getString(10));
            type.setText(cursor.getString(11));
            customer.setText(cursor.getString(12));
            customer_id.setText(cursor.getBlob(13).toString());
            supplier_id.setText(cursor.getBlob(14).toString());
            job_number.setText(cursor.getBlob(15).toString());
            address.setText(cursor.getBlob(16).toString());
            time_production.setText(cursor.getString(17));
            quantity_packaging.setText(cursor.getString(18));
            quantity_child.setText(cursor.getString(19));
            sequence_qr.setText(cursor.getString(22));
            sequence_data_part.setText(cursor.getString(23));

            final Spinner ListStation = station_number;
            final Spinner ListPosition = position;
            final Spinner ListGoods = goods;
            final Spinner LineProd = line_production;

            Simpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
                    db.execSQL("update product set station_num='" +
                            station_number.getSelectedItem().toString() + "', part_name='" +
                            part_name.getText().toString() + "', position='" +
                            position.getSelectedItem().toString() + "', pn_api='" +
                            part_number_api.getText().toString() + "', pn_cust='" +
                            part_number_cust.getText().toString() + "', ptloc='" +
                            ptloc.getText().toString() + "', sfgwh='" +
                            sfgwh.getText().toString() + "', fgwh='" +
                            fgwh.getText().toString() + "', nkiwh='" +
                            nkiwh.getText().toString() + "', type='" +
                            type.getText().toString() + "', customer='" +
                            customer.getText().toString() + "', cust_id='" +
                            customer_id.getText().toString() + "', supplier_id='" +
                            supplier_id.getText().toString() + "', job_num='" +
                            job_number.getText().toString() + "', address='" +
                            address.getText().toString() + "', time_production='" +
                            time_production.getText().toString() + "', qty_packaging='" +
                            quantity_packaging.getText().toString() + "', qty_child='" +
                            quantity_child.getText().toString() + "', goods='" +
                            goods.getSelectedItem().toString() + "', line_prod='" +
                            line_production.getSelectedItem().toString() + "', seq_qr='" +
                            sequence_qr.getText().toString() + "', seq_data_part='" +
                            sequence_data_part.getText().toString() + "', TRIAL853='" +
                            "T" + "' where sku='" + sku.getText().toString() + "'");
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    finish();
                }
            });
        }
    }
}