package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton radioButtonEx1;
    RadioButton radioButtonEx2;
    RadioButton radioButtonEx3;
    Button buttonExecute;
    Button buttonExitActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonEx1 = findViewById(R.id.radioButtonEx1);
        radioButtonEx2 = findViewById(R.id.radioButtonEx2);
        radioButtonEx3 = findViewById(R.id.radioButtonEx3);
        buttonExecute = findViewById(R.id.buttonExecute);
        buttonExitActivity = findViewById(R.id.buttonExitActivity);

        buttonExecute.setOnClickListener(this::execute);
        buttonExitActivity.setOnClickListener(this::exitActivity);
    }

    public void execute(View view) {
        if (radioButtonEx1.isChecked() || radioButtonEx2.isChecked() || radioButtonEx3.isChecked()) {
            if (radioButtonEx1.isChecked()) {
                Intent intent = new Intent(this, AActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Chưa có chức năng", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Chưa chọn bài toán!", Toast.LENGTH_SHORT).show();
        }
    }

    public void exitActivity(View view) {
        finish();
    }
}