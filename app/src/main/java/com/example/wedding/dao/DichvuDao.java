package com.example.wedding.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wedding.Domain.Dichvu;
import com.example.wedding.Helper.Sqldatabase;

import java.util.ArrayList;
import java.util.List;

public class DichvuDao {
    private SQLiteDatabase db;

    public DichvuDao(Context context) {
        Sqldatabase sqldatabase = new Sqldatabase(context);
        db = sqldatabase.getWritableDatabase();
    }

    public long insert(Dichvu dichvu) {
        ContentValues contentValues = new ContentValues();
        //   contentValues.put("Id", monan.Id_monan);
        contentValues.put("Ten khong gian", dichvu.Khonggiantiec);
        contentValues.put("Ten", dichvu.Ten);
        contentValues.put("Anh", dichvu.Anh);

        return db.insert("Dichvu", null, contentValues);
    }

    public int update(Dichvu dichvu) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id_dichvu", dichvu.Id_dichvu);
        contentValues.put("Tenkhonggian", dichvu.Khonggiantiec);
        contentValues.put("Ten", dichvu.Ten);
        contentValues.put("Anh", dichvu.Anh);
        return db.update("Dichvu", contentValues, "Id_dichvu=?", new String[]{String.valueOf(dichvu.Id_dichvu)});
    }

    public int delete(String id) {
        return db.delete("Dichvu", "Id_dichvu=?", new String[]{id});
    }

    public List<Dichvu> getAll() {
        String sql = "select * from Dichvu";
        return getData(sql);
    }

    public Dichvu getID(String id) {
        String sql = "select * from Sach where Id_dichvu=?";
        List<Dichvu> list2 = new ArrayList<>();
        list2 = getData(sql, id);
        return list2.get(0);

    }

    @SuppressLint("Range")
    private List<Dichvu> getData(String sql, String... selectionArgs) {
        List<Dichvu> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Dichvu dichvu = new Dichvu();
            dichvu.Id_dichvu = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Id_dichvu")));
            dichvu.Khonggiantiec = cursor.getString(cursor.getColumnIndex("Ten"));
            dichvu.Ten = cursor.getString(cursor.getColumnIndex("DanhGia"));
            dichvu.Anh = cursor.getString(cursor.getColumnIndex("Anh"));
            list.add(dichvu);
        }
        return list;
    }
}
