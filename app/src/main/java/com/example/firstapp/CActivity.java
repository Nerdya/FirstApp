package com.example.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CActivity extends AppCompatActivity {
    EditText editTextA;
    EditText editTextB;
    EditText editTextC;
    EditText editTextResult;
    Button buttonFindMaxMin;
    Button buttonReturnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        // Ánh xạ
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        editTextResult = findViewById(R.id.editTextResult);
        buttonFindMaxMin = findViewById(R.id.buttonFindMaxMin);
        buttonReturnResult = findViewById(R.id.buttonReturnResult);

        Intent intent = getIntent();
        final int a = intent.getIntExtra("varA", 0);
        final int b = intent.getIntExtra("varB", 0);
        final int c = intent.getIntExtra("varC", 0);
        editTextA.setText(String.valueOf(a));
        editTextB.setText(String.valueOf(b));
        editTextC.setText(String.valueOf(c));

        buttonFindMaxMin.setOnClickListener(view -> findMaxMin());
        buttonReturnResult.setOnClickListener(view -> returnResult());
    }

    private void findMaxMin() {
        int a = Integer.parseInt(editTextA.getText().toString());
        int b = Integer.parseInt(editTextB.getText().toString());
        int c = Integer.parseInt(editTextC.getText().toString());
        int maxValue = Math.max(Math.max(a, b), c);
        int minValue = Math.min(Math.min(a, b), c);
        String result = "Max: " + maxValue + "\nMin: " + minValue;
        editTextResult.setText(result);
    }

    private void returnResult() {
        String textResult = editTextResult.getText().toString();
        if (!textResult.equals("")) {
            Intent intent = new Intent(CActivity.this, AActivity.class);
            intent.putExtra("result", textResult);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Không có kết quả để gửi lại", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        // Prepare the result data to send back to Activity A
        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", "User uses back button");

        // Set the result code and data
        setResult(Activity.RESULT_CANCELED, resultIntent);

        // Call finish to close Activity C and return to Activity A
        finish();
    }
}