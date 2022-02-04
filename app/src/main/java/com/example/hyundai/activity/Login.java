package com.example.hyundai.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hyundai.R;
import com.example.hyundai.SQLite.DatabaseHelper;
import com.example.hyundai.SQLite.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    private final static String NPK = "npk";
    private final static String NAMA = "name";
    private final static String TRIAL = "trial";

    SharedPreferences mSharedPreferences;
    private final static String APP_NAME= "Hyundai";
    private final static String LOCKED = "0";

    DatabaseHelper mDatabaseHelper;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mDatabaseHelper = new DatabaseHelper(this);
        etUsername = findViewById(R.id.userLog);
        etPassword = findViewById(R.id.passwordLog);
        btnLogin = findViewById(R.id.btnReset);

        mSharedPreferences = getSharedPreferences(APP_NAME, MODE_PRIVATE);
        String GLOCKED = mSharedPreferences.getString(LOCKED, "0");
        Log.e("GLOCKED", "onCreate: " + GLOCKED );

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String npk = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                User currentUser = mDatabaseHelper.Authenticate(new User(null,npk, null, password, null, null, 0));

                if (currentUser != null) {
                    if (currentUser.getUsergroup().equals("Operator") && GLOCKED.equals("0")){
                        Intent intent=new Intent(Login.this,SelectScanner.class);
                        intent.putExtra(NPK, currentUser.getNpk());
                        intent.putExtra(NAMA, currentUser.getName());
                        intent.putExtra(TRIAL, currentUser.getTrial857());
//                        intent.getStringExtra(finalGLOCKED);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                    }else if (currentUser.getUsergroup().equals("Operator") && GLOCKED.equals("1")){
                        Intent intent=new Intent(Login.this,locked.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    } else {

                        Intent intent=new Intent(Login.this,Leader.class);
                        intent.putExtra(NPK, currentUser.getNpk());
                        intent.putExtra(NAMA, currentUser.getName());
                        intent.putExtra(TRIAL, currentUser.getTrial857());
//                        intent.getStringExtra(finalGLOCKED);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                } else {
                    //User Logged in Failed
                    Snackbar.make(btnLogin, "Failed to log in , please try again", Snackbar.LENGTH_LONG).show();

                }
            }
        });
    }

    @Override
    public void onBackPressed() {    }
}