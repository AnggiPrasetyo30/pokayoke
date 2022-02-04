package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hyundai.R;
import com.example.hyundai.SQLite.DatabaseHelper;
import com.example.hyundai.SQLite.Product;
import com.example.hyundai.SQLite.shopping;
import com.example.hyundai.adapter.recycler_produk;
import com.example.hyundai.adapter.recycler_riwayat;

import java.text.DateFormat;
import java.util.List;

public class list_riwayat extends AppCompatActivity {

    private recycler_riwayat adDataf;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_riwayat);

        mDatabaseHelper = new DatabaseHelper(this);
        RecyclerView recyclerView = findViewById(R.id.viewf);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<shopping> itemP = mDatabaseHelper.retrieve_riwayat();
        adDataf = new recycler_riwayat(this, itemP);
        adDataf.notifyDataSetChanged();
        recyclerView.setAdapter(adDataf);

        String tanggal = itemP.get(0).datetime;
        Toast.makeText(this, tanggal, Toast.LENGTH_SHORT).show();
    }
}