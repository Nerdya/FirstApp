package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextUsername;
    EditText editTextPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Toast.makeText(MainActivity.this, "Đăng nhập thành công",
                        Toast.LENGTH_SHORT).show();
                openSolveEquationActivity(view);
            } else {
                Toast.makeText(MainActivity.this, "Username hoặc password không đúng",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openSolveEquationActivity(View view) {
        Intent intent = new Intent(this, SolveEquationActivity.class);
        startActivity(intent);
    }
}