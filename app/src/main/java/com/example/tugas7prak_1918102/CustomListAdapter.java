package com.example.tugas7prak_1918102;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter  extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<SPBU> SPBU;
    public CustomListAdapter(Activity activity, List<SPBU> SPBU) {
        this.activity = activity;
        this.SPBU = SPBU;
    }
    @Override
    public int getCount() {
        return SPBU.size();
    }
    @Override
    public Object getItem(int location) {
        return SPBU.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView namabb = (TextView)
                convertView.findViewById(R.id.text_namabb);
        TextView jenisbb = (TextView)
                convertView.findViewById(R.id.text_jenisbb);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        SPBU spbu1 = SPBU.get(position);
        namabb.setText("Nama : "+ spbu1.get_namabb());
        jenisbb.setText("Jenis : "+ spbu1.get_jenisbb());
        return convertView;
    }
}
