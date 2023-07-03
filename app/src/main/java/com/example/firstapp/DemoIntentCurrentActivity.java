package com.example.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class DemoIntentCurrentActivity extends AppCompatActivity {
    EditText editTextA;
    EditText editTextB;
    EditText editTextC;
    Button buttonSendFirstNext;
    Button buttonSendSecondNext;
    private ActivityResultLauncher<Intent> sendToFirstNextLauncher;
    private ActivityResultLauncher<Intent> sendToSecondNextLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_intent_current);

        // Initialize launchers
        sendToFirstNextLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        int resultValue = data.getIntExtra("result", 0);
                        Toast.makeText(this, "" + resultValue, Toast.LENGTH_LONG).show();
                    }
                }
        );

        sendToSecondNextLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String resultValue = data.getStringExtra("result");
                        Toast.makeText(this, resultValue, Toast.LENGTH_LONG).show();
                    }
                }
        );

        // Ánh xạ
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        buttonSendFirstNext = findViewById(R.id.buttonSendFirstNext);
        buttonSendSecondNext = findViewById(R.id.buttonSendSecondNext);

        buttonSendFirstNext.setOnClickListener(view -> sendToFirstNext());
        buttonSendSecondNext.setOnClickListener(view -> sendToSecondNext());
    }


    private void sendToFirstNext() {
        if (!editTextA.getText().toString().equals("") && !editTextB.getText().toString().equals("")
                && !editTextC.getText().toString().equals("")) {
            try {
                int a = Integer.parseInt(String.valueOf(editTextA.getText()));
                int b = Integer.parseInt(String.valueOf(editTextB.getText()));
                int c = Integer.parseInt(String.valueOf(editTextC.getText()));

                Intent intent = new Intent(DemoIntentCurrentActivity.this, DemoIntentFirstNextActivity.class);
                intent.putExtra("varA", a);
                intent.putExtra("varB", b);
                intent.putExtra("varC", c);
                sendToFirstNextLauncher.launch(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Sai định dạng a, b hoặc c", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Nhập đầy đủ a, b, c", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendToSecondNext() {
        if (!editTextA.getText().toString().equals("") && !editTextB.getText().toString().equals("")
                && !editTextC.getText().toString().equals("")) {
            try {
                int a = Integer.parseInt(String.valueOf(editTextA.getText()));
                int b = Integer.parseInt(String.valueOf(editTextB.getText()));
                int c = Integer.parseInt(String.valueOf(editTextC.getText()));

                Intent intent = new Intent(DemoIntentCurrentActivity.this, DemoIntentSecondNextActivity.class);
                intent.putExtra("varA", a);
                intent.putExtra("varB", b);
                intent.putExtra("varC", c);
                sendToSecondNextLauncher.launch(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Sai định dạng a, b hoặc c", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Nhập đầy đủ a, b, c", Toast.LENGTH_SHORT).show();
        }
    }
}