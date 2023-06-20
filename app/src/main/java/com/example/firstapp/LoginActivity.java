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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ánh xạ
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(view -> {
//            Log.i("username", String.valueOf(editTextUsername.getText()));
//            Log.i("password", String.valueOf(editTextPassword.getText()))
            boolean valid = String.valueOf(editTextUsername.getText()).equals("username") &&
                    String.valueOf(editTextPassword.getText()).equals("password");
            if (valid) {
                Toast.makeText(LoginActivity.this, "Đăng nhập thành công",
                        Toast.LENGTH_SHORT).show();
                openMainActivity(view);
            } else {
                Toast.makeText(LoginActivity.this, "Username hoặc password không đúng",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}