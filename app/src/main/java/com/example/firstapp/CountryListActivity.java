package com.example.firstapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class CountryListActivity extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        list = findViewById(R.id.listView);
        list.setDivider(null);
        String[] countryNames = {"Vietnam", "England", "USA", "Switzerland"};
        int[] flags = {R.drawable.flag_vn, R.drawable.flag_uk, R.drawable.flag_us, R.drawable.flag_ch};
        CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);
        list.setAdapter(adapter);
    }
}