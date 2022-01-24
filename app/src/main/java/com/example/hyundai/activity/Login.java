package com.example.hyundai.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
    private final static String PASSWORD = "password";
    private final static String NAMA = "name";

    DatabaseHelper mDatabaseHelper;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Kname = "nameKey";
    public static final String Knpk = "npkKey";
    public static final String Kpassword = "passwordKey";
    public static final String Kusername = "usernameKey";
    public static final String Kusergroup = "usergroupKey";
    SharedPreferences sharedpreferences;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mDatabaseHelper = new DatabaseHelper(this);
        etUsername = findViewById(R.id.userLog);
        etPassword = findViewById(R.id.passwordLog);
        btnLogin = findViewById(R.id.btnReset);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String npk = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                User currentUser = mDatabaseHelper.Authenticate(new User(null,npk, null, password, null));

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Kname, currentUser.getName());
                editor.putString(Knpk, npk);
                editor.putString(Kpassword, password);
                editor.putString(Kusername, currentUser.getUsername());
                editor.putString(Kusergroup, currentUser.getUsergroup());
                editor.commit();

                if (currentUser != null) {
                    if (currentUser.getUsergroup().equals("Operator")){
                        Intent intent=new Intent(Login.this,SelectScanner.class);
                        intent.putExtra(NPK, currentUser.getNpk());
                        intent.putExtra(NAMA, currentUser.getName());
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }else{
                        Intent intent=new Intent(Login.this,SelectScannerLeader.class);
                        intent.putExtra(NPK, currentUser.getNpk());
                        intent.putExtra(NAMA, currentUser.getName());
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

}



 /*if (mDatabaseHelper.checkUser(npk,password)) {
                    Intent intent = new Intent(Login.this, SelectScanner.class);
                    startActivity(intent);
                }
                else {

                }*/