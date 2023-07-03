package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonSolveEquation;
    Button buttonCountryList;
    Button buttonDemoIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSolveEquation = findViewById(R.id.buttonSolveEquation);
        buttonCountryList = findViewById(R.id.buttonCountryList);
        buttonDemoIntent = findViewById(R.id.buttonDemoIntent);

        buttonSolveEquation.setOnClickListener(this::openSolveEquationActivity);
        buttonCountryList.setOnClickListener(this::openCountryListActivity);
        buttonDemoIntent.setOnClickListener(this::openDemoIntentActivity);
    }

    public void openSolveEquationActivity(View view) {
        Intent intent = new Intent(this, SolveEquationActivity.class);
        startActivity(intent);
    }

    public void openCountryListActivity(View view) {
        Intent intent = new Intent(this, CountryListActivity.class);
        startActivity(intent);
    }

    public void openDemoIntentActivity(View view) {
        Intent intent = new Intent(this, DemoIntentCurrentActivity.class);
        startActivity(intent);
    }
}