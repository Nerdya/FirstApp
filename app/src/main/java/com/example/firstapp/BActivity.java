package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BActivity extends AppCompatActivity {
    EditText editTextA;
    EditText editTextB;
    EditText editTextC;
    EditText editTextResult;
    Button buttonSolve;
    Button buttonReturnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // Ánh xạ
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        editTextResult = findViewById(R.id.editTextResult);
        buttonSolve = findViewById(R.id.buttonFindMaxMin);
        buttonReturnResult = findViewById(R.id.buttonReturnResult);

        Intent intent = getIntent();
        final int a = intent.getIntExtra("varA",0);
        final int b = intent.getIntExtra("varB",0);
        final int c = intent.getIntExtra("varC",0);
        editTextA.setText(String.valueOf(a));
        editTextB.setText(String.valueOf(b));
        editTextC.setText(String.valueOf(c));

        buttonSolve.setOnClickListener(view -> solve());
        buttonReturnResult.setOnClickListener(view -> returnResult());
    }

    private void solve() {
        int a = Integer.parseInt(editTextA.getText().toString());
        int b = Integer.parseInt(editTextB.getText().toString());
        int c = Integer.parseInt(editTextC.getText().toString());
        String result = solveQuadraticEquation(a, b, c);
        editTextResult.setText(result);
    }

    private void returnResult() {
        String textResult = editTextResult.getText().toString();
        if (!textResult.equals("")) {
            Intent intent = new Intent(BActivity.this, AActivity.class);
            intent.putExtra("result", textResult);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Không có kết quả để gửi lại", Toast.LENGTH_SHORT).show();
        }
    }

    public static String solveQuadraticEquation(int a, int b, int c) {
        if (a == 0) {
            // Phương trình thành phương trình bậc 1: bx + c = 0
            if (b == 0) {
                if (c == 0) {
                    return "PT có vô số nghiệm.";
                } else {
                    return "PT vô nghiệm.";
                }
            } else {
                double root = -c / (double) b;
                return "PT có 1 nghiệm:\n" +
                        "x = " + root;
            }
        } else {
            // Phương trình bậc 2: ax^2 + bx + c = 0
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double root1 = (-b + Math.sqrt(delta)) / (2 * a);
                double root2 = (-b - Math.sqrt(delta)) / (2 * a);

                return "x1 = " + root1 + "\n" +
                        "x2 = " + root2;
            } else if (delta == 0) {
                double root = -b / (2 * a);

                return "PT có nghiệm kép:\n" +
                        "x = " + root;
            } else {
                return "PT vô nghiệm.";
            }
        }
    }
}