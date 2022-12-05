package com.example.wedding.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wedding.Domain.Dichvu;
import com.example.wedding.Domain.Thietlap;
import com.example.wedding.Helper.Sqldatabase;

import java.util.ArrayList;
import java.util.List;

public class ThietLapDao {
    private SQLiteDatabase db;

    public ThietLapDao(Context context) {
        Sqldatabase sqldatabase = new Sqldatabase(context);
        db = sqldatabase.getWritableDatabase();
    }

    public long insert(Thietlap dichvu) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id_thietlap", dichvu.getId_thietlap());
        contentValues.put("Title", dichvu.getTitle());
        contentValues.put("Review", dichvu.getReview());
        contentValues.put("Anh", dichvu.getAnh());

        return db.insert("Thietlap", null, contentValues);
    }
    public List<Thietlap> getAll() {
        String sql = "select * from Thietlap";
        return getData(sql);
    }
    @SuppressLint("Range")
    private List<Thietlap> getData(String sql, String... selectionArgs) {
        List<Thietlap> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Thietlap dichvu = new Thietlap();
            dichvu.setId_thietlap(Integer.parseInt(cursor.getString(cursor.getColumnIndex("Id_thietlap"))));
            dichvu.setTitle(cursor.getString(cursor.getColumnIndex("Title")));
            dichvu.setReview(cursor.getString(cursor.getColumnIndex("Review")));
            dichvu.setAnh(cursor.getString(cursor.getColumnIndex("Anh")));
            list.add(dichvu);
        }
        return list;
    }
    public long deleteTable(){
        return db.delete("Thietlap",null,null);
    }
    public long deleteById(int id){
        return db.delete("Thietlap", "Id_thietlap = ?",new String[]{String.valueOf(id)});
    }
}
