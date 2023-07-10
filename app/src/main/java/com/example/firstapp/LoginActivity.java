package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonLogin;
    Button buttonExit;
    String username = "admin";
    String password = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ánh xạ
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonExit = findViewById(R.id.buttonExit);

        buttonLogin.setOnClickListener(this::login);
        buttonExit.setOnClickListener(this::exit);
    }

    private void login(View view) {
        String textUsername = editTextUsername.getText().toString();
        String textPassword = editTextPassword.getText().toString();
        if (!textUsername.equals("") && !textPassword.equals("")) {
            if (textUsername.equals(username) && textPassword.equals(password)) {
                Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                openMainActivity(view);
            } else {
                Toast.makeText(LoginActivity.this, "Username hoặc password không đúng", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Nhập đầy đủ username và password", Toast.LENGTH_SHORT).show();
        }
    }

    private void exit(View view) {
        finish();
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}