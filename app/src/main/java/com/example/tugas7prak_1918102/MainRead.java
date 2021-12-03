package com.example.tugas7prak_1918102;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead  extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<SPBU> ListSPBU = new ArrayList<SPBU>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListSPBU
        );
        mListView = (ListView) findViewById(R.id.list_spbu);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListSPBU.clear();
        List<SPBU> spbu = db.ReadSPBU();
        for (SPBU Spbu : spbu) {
            SPBU daftar = new SPBU();
            daftar.set_id(Spbu.get_id());
            daftar.set_namabb(Spbu.get_namabb());
            daftar.set_jenisbb(Spbu.get_jenisbb());
            ListSPBU.add(daftar);
            if ((ListSPBU.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        SPBU detailSPBU = (SPBU)o;
        String Sid = detailSPBU.get_id();
        String Snamabb = detailSPBU.get_namabb();
        String Sjenisbb = detailSPBU.get_jenisbb();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inamabb", Snamabb);
        goUpdel.putExtra("Ijenisbb", Sjenisbb);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListSPBU.clear();
        mListView.setAdapter(adapter_off);
        List<SPBU> spbu = db.ReadSPBU();
        for (SPBU Spbu : spbu) {
            SPBU daftar = new SPBU();
            daftar.set_id(Spbu.get_id());
            daftar.set_namabb(Spbu.get_namabb());
            daftar.set_jenisbb(Spbu.get_jenisbb());
            ListSPBU.add(daftar);
            if ((ListSPBU.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
