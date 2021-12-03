package com.example.tugas7prak_1918102;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel  extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snamabb, Sjenisbb;
    private EditText Enamabb, Ejenisbb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snamabb = i.getStringExtra("Inamabb");
        Sjenisbb = i.getStringExtra("Ijenisbb");
        Enamabb = (EditText) findViewById(R.id.updel_namabb);
        Ejenisbb = (EditText) findViewById(R.id.updel_jenisbb);
        Enamabb.setText(Snamabb);
        Ejenisbb.setText(Sjenisbb);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snamabb = String.valueOf(Enamabb.getText());
                Sjenisbb = String.valueOf(Ejenisbb.getText());
                if (Snamabb.equals("")){
                    Enamabb.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama bahan bakar",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenisbb.equals("")){
                    Ejenisbb.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis bahan bakar",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateSPBU(new SPBU(Sid, Snamabb, Sjenisbb));
                    Toast.makeText(MainUpdel.this, "Data telah diubah",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteSPBU(new SPBU(Sid, Snamabb, Sjenisbb));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}


