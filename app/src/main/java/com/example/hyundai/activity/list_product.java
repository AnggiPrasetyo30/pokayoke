package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hyundai.R;
import com.example.hyundai.SQLite.DatabaseHelper;
import com.example.hyundai.SQLite.Product;
import com.example.hyundai.adapter.recycler_produk;

import java.util.ArrayList;
import java.util.List;

public class list_product extends AppCompatActivity {

    private recycler_produk adDataf;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        mDatabaseHelper = new DatabaseHelper(this);
        RecyclerView recyclerView = findViewById(R.id.viewf);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Product> itemP = mDatabaseHelper.retrieve_produk();
        adDataf = new recycler_produk(this, itemP);
        adDataf.notifyDataSetChanged();
        recyclerView.setAdapter(adDataf);

        Button btnCreate = findViewById(R.id.btnBuat);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(list_product.this, create_product.class);
                startActivity(intent);
            }
        });
    }
}