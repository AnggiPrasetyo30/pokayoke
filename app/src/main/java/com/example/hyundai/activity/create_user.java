package com.example.hyundai.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hyundai.R;
import com.example.hyundai.SQLite.DatabaseHelper;
import com.example.hyundai.SQLite.User;

import java.util.Calendar;

public class create_user extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;
    EditText NPK, Username, Password, RFIDTag, Nama, OpSkill;
    Spinner Usergroup, Department;
    Button Simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        mDatabaseHelper = new DatabaseHelper(this);
        NPK = (EditText) findViewById(R.id.fieldNpk);
        Username = (EditText) findViewById(R.id.fieldUsername);
        Password = (EditText) findViewById(R.id.fieldPassword);
        RFIDTag = (EditText) findViewById(R.id.fieldRFID);
        Nama = (EditText) findViewById(R.id.fieldNama);
        OpSkill = (EditText) findViewById(R.id.fieldOpSkill);
        Usergroup = (Spinner) findViewById(R.id.fieldUsergroup);
        Department = (Spinner) findViewById(R.id.fieldDepartement);
        Simpan = (Button) findViewById(R.id.btnBuat);

        final Spinner ListUserGroup = Usergroup;
        final Spinner ListDepartement = Department;

        Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
                db.execSQL("insert into user(npk, username, password, rfid_tag, name, usergroup, departement, op_skill, last_login, status, created_at, updated_at, TRIAL857, status_akun) values('" +
                        NPK.getText().toString() + "','" + Username.getText().toString() + "','" + Password.getText().toString() + "','" +
                        RFIDTag.getText().toString() + "','" + Nama.getText().toString() + "','" + ListUserGroup.getSelectedItem().toString() + "','" +
                        ListDepartement.getSelectedItem().toString() + "','" + OpSkill.getText().toString() + "','" + " " + "','" + "Active" + "','" + String.valueOf(Calendar.getInstance().getTime()) + "','" + " " + "','" + "T" + "','" + "0" + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}