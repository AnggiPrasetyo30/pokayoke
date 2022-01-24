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
import com.example.hyundai.SQLite.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    EditText etUsername, etPassword;
    TextInputLayout textInputLayoutEmail,textInputLayoutPassword;
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

                /*String success = mDatabaseHelper.loadHandler(npk,password);

                if (sucess != null) {
                    Snackbar.make(btnLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                    Intent intent=new Intent(Login.this,SelectScanner.class);
                    startActivity(intent);
                    finish();

                } else {

                    //User Logged in Failed
                    Snackbar.make(btnLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                }*/

                User currentUser = mDatabaseHelper.Authenticate(new User(null, npk, null, password));
                if (currentUser != null) {
                    Snackbar.make(btnLogin, "Successfully Logged in!", Snackbar.LENGTH_LONG).show();
                    Intent intent=new Intent(Login.this,SelectScanner.class);
                    intent.putExtra("NPK", currentUser.getNpk());
                    intent.putExtra("NAMA", currentUser.getName());
                    startActivity(intent);
                    finish();
                } else {

                    //User Logged in Failed
                    Snackbar.make(btnLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                }
            }
        });
    }

}



 /*if (mDatabaseHelper.checkUser(npk,password)) {
                    Intent intent = new Intent(Login.this, SelectScanner.class);
                    startActivity(intent);
                }
                else {

                }*/