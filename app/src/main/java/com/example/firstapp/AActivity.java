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

public class AActivity extends AppCompatActivity {
    EditText editTextA;
    EditText editTextB;
    EditText editTextC;
    Button buttonSendToB;
    Button buttonSendToC;
    EditText editTextResultRetrieved;
    private ActivityResultLauncher<Intent> sendToBLauncher;
    private ActivityResultLauncher<Intent> sendToCLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        // Initialize launchers
        sendToBLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    int resultCode = result.getResultCode();
                    Intent data = result.getData();
                    String textResult = "Activity B, resultCode: " + resultCode + "\n" +
                            "data: " + data.getStringExtra("result");
                    editTextResultRetrieved.setText(textResult);
//                    Toast.makeText(this, textResult, Toast.LENGTH_LONG).show();
                }
        );

        sendToCLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    int resultCode = result.getResultCode();
                    Intent data = result.getData();
                    String textResult = "Activity C, resultCode: " + resultCode + "\n" +
                            "data: " + data.getStringExtra("result");
                    editTextResultRetrieved.setText(textResult);
//                    Toast.makeText(this, textResult, Toast.LENGTH_LONG).show();
                }
        );

        // Ánh xạ
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        buttonSendToB = findViewById(R.id.buttonSendToB);
        buttonSendToC = findViewById(R.id.buttonSendToC);
        editTextResultRetrieved = findViewById(R.id.editTextResultRetrieved);

        buttonSendToB.setOnClickListener(view -> sendToB());
        buttonSendToC.setOnClickListener(view -> sendToC());
    }


    private void sendToB() {
        String textA = editTextA.getText().toString();
        String textB = editTextB.getText().toString();
        String textC = editTextC.getText().toString();
        if (!textA.equals("") && !textB.equals("") && !textC.equals("")) {
            try {
                int a = Integer.parseInt(textA);
                int b = Integer.parseInt(textB);
                int c = Integer.parseInt(textC);

                Intent intent = new Intent(AActivity.this, BActivity.class);
                intent.putExtra("varA", a);
                intent.putExtra("varB", b);
                intent.putExtra("varC", c);
                sendToBLauncher.launch(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Sai định dạng a, b hoặc c", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Nhập đầy đủ a, b, c", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendToC() {
        String textA = editTextA.getText().toString();
        String textB = editTextB.getText().toString();
        String textC = editTextC.getText().toString();
        if (!textA.equals("") && !textB.equals("") && !textC.equals("")) {
            try {
                int a = Integer.parseInt(textA);
                int b = Integer.parseInt(textB);
                int c = Integer.parseInt(textC);

                Intent intent = new Intent(AActivity.this, CActivity.class);
                intent.putExtra("varA", a);
                intent.putExtra("varB", b);
                intent.putExtra("varC", c);
                sendToCLauncher.launch(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Sai định dạng a, b hoặc c", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Nhập đầy đủ a, b, c", Toast.LENGTH_SHORT).show();
        }
    }
}