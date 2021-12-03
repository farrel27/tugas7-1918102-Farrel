package com.example.tugas7prak_1918102;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enamabb, Ejenisbb;
    private String Snamabb, Sjenisbb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enamabb = (EditText) findViewById(R.id.create_namabb);
        Ejenisbb = (EditText) findViewById(R.id.create_jenisbb);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snamabb = String.valueOf(Enamabb.getText());
                Sjenisbb = String.valueOf(Ejenisbb.getText());
                if (Snamabb.equals("")){
                    Enamabb.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama Bahan Bakar",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sjenisbb.equals("")) {
                    Ejenisbb.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Jenis Bahan Bakar",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enamabb.setText("");
                    Ejenisbb.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateSPBU(new SPBU(null, Snamabb, Sjenisbb));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
