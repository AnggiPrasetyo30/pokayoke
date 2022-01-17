package com.example.hyundai;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hyundai.SQLite.DatabaseHelper;

public class Login extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    DatabaseHelper mDatabaseHelper;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mDatabaseHelper = new DatabaseHelper(this);
        etUsername = findViewById(R.id.userLog);
        etPassword = findViewById(R.id.passwordLog);
        btnLogin = findViewById(R.id.btnReset);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String npk = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (mDatabaseHelper.checkUser(npk,password)) {
                    Intent intent = new Intent(Login.this, SelectScanner.class);
                    startActivity(intent);
                }
                else {

                }
            }
        });
    }

}
