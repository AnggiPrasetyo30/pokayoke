package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hyundai.R;
import com.example.hyundai.SQLite.DatabaseHelper;
import com.example.hyundai.SQLite.User;
import com.example.hyundai.SQLite.shopping;
import com.example.hyundai.adapter.recycler_produk;
import com.example.hyundai.adapter.recycler_riwayat;
import com.example.hyundai.adapter.recycler_user;

import java.util.List;

public class list_user extends AppCompatActivity {

    private recycler_user adDataf;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        mDatabaseHelper = new DatabaseHelper(this);
        RecyclerView recyclerView = findViewById(R.id.viewf);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<User> itemP = mDatabaseHelper.retrieve_user();
        adDataf = new recycler_user(this, itemP);
        adDataf.notifyDataSetChanged();
        recyclerView.setAdapter(adDataf);
    }
}