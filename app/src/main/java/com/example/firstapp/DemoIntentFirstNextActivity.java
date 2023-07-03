package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DemoIntentFirstNextActivity extends AppCompatActivity {
    EditText editTextA;
    EditText editTextB;
    EditText editTextC;
    EditText editTextResult;
    Button buttonSum;
    Button buttonReturnResult;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_intent_first_next);

        // Ánh xạ
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        editTextResult = findViewById(R.id.editTextResult);
        buttonSum = findViewById(R.id.buttonSolve);
        buttonReturnResult = findViewById(R.id.buttonReturnResult);

        Intent intent = getIntent();
        final int a = intent.getIntExtra("varA", 0);
        final int b = intent.getIntExtra("varB", 0);
        final int c = intent.getIntExtra("varC", 0);
        editTextA.setText(String.valueOf(a));
        editTextB.setText(String.valueOf(b));
        editTextC.setText(String.valueOf(c));

        buttonSum.setOnClickListener(view -> sum());
        buttonReturnResult.setOnClickListener(view -> returnResult());
    }

    private void sum() {
        int a = Integer.parseInt(String.valueOf(editTextA.getText()));
        int b = Integer.parseInt(String.valueOf(editTextB.getText()));
        int c = Integer.parseInt(String.valueOf(editTextC.getText()));
        result = a + b + c;
        String resultText = "Tổng: " + result;
        editTextResult.setText(resultText);
    }

    private void returnResult() {
        if (!editTextResult.getText().toString().equals("")) {
            Intent intent = new Intent(DemoIntentFirstNextActivity.this, DemoIntentCurrentActivity.class);
//            int result = Integer.parseInt(editTextResult.getText().toString());
//            intent.putExtra("result", result);
            intent.putExtra("result", result);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Không có kết quả để gửi lại", Toast.LENGTH_SHORT).show();
        }
    }
}