package com.example.tugas7prak_1918102;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_spbu";
    private static final String tb_spbu = "tb_spbu";
    private static final String tb_spbu_id = "id";
    private static final String tb_spbu_namabb = "namabb";
    private static final String tb_spbu_jenisbb = "jenisbb";
    private static final String CREATE_TABLE_SPBU = "CREATE TABLE " +
    tb_spbu +"("
            + tb_spbu_id + " INTEGER PRIMARY KEY ,"
            + tb_spbu_namabb + " TEXT ,"
            + tb_spbu_jenisbb + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SPBU);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateSPBU(SPBU data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_spbu_id, data.get_id());
        values.put(tb_spbu_namabb, data.get_namabb());
        values.put(tb_spbu_jenisbb, data.get_jenisbb());
        db.insert(tb_spbu, null, values);
        db.close();
    }
    public List<SPBU> ReadSPBU() {
        List<SPBU> listSPBU = new ArrayList<SPBU>();
        String selectQuery = "SELECT * FROM " + tb_spbu;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                SPBU data = new SPBU();
                data.set_id(cursor.getString(0));
                data.set_namabb(cursor.getString(1));
                data.set_jenisbb(cursor.getString(2));
                listSPBU.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listSPBU;
    }
    public int UpdateSPBU (SPBU data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_spbu_namabb, data.get_namabb());
        values.put(tb_spbu_jenisbb, data.get_jenisbb());
        return db.update(tb_spbu, values, tb_spbu_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteSPBU(SPBU data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_spbu,tb_spbu_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
