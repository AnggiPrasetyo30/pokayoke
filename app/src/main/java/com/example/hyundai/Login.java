package com.example.hyundai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        etUsername = findViewById(R.id.userLog);
        etPassword = findViewById(R.id.passwordLog);
        btnLogin = findViewById(R.id.btnReset);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SelectScanner.class);
                startActivity(intent);
            }
        });
    }

}
