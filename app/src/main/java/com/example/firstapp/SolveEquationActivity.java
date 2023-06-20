package com.example.firstapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SolveEquationActivity extends AppCompatActivity {
    EditText editTextA;
    EditText editTextB;
    EditText editTextC;
    EditText editTextResult;
    Button buttonSolve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_equation);

        // Ánh xạ
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        editTextResult = findViewById(R.id.editTextResult);
        buttonSolve = findViewById(R.id.buttonSolve);
        buttonSolve.setOnClickListener(view -> {
            int a = Integer.parseInt(String.valueOf(editTextA.getText()));
            int b = Integer.parseInt(String.valueOf(editTextB.getText()));
            int c = Integer.parseInt(String.valueOf(editTextC.getText()));
            String result = solveQuadraticEquation(a, b, c);
            editTextResult.setText(result);
        });
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

                return "PT có 2 nghiệm:\n" +
                        "x1 = " + root1 + "\n" +
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