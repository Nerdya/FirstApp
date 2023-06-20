package com.example.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] list;
    int[] flags;
    LayoutInflater inflater;

    public CustomAdapter(Context context, String[] country, int[] flag) {
        this.context = context;
        this.list = country;
        this.flags = flag;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_item, parent, false);
        TextView country = (TextView) convertView.findViewById(R.id.textViewCountryName);
        ImageView flag = (ImageView) convertView.findViewById(R.id.imageViewFlag);
        country.setText(list[position]);
        flag.setImageResource(flags[position]);
        return convertView;
    }
}
