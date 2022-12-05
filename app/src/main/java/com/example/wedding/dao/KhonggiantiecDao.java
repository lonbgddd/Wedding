package com.example.wedding.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wedding.Domain.Khonggiantiec;
import com.example.wedding.Helper.Sqldatabase;

import java.util.ArrayList;
import java.util.List;

public class KhonggiantiecDao {
    private SQLiteDatabase db;

    public KhonggiantiecDao(Context context) {
        Sqldatabase sqldatabase = new Sqldatabase(context);
        db = sqldatabase.getWritableDatabase();
    }

    public long insert(Khonggiantiec khonggiantiec) {
        ContentValues contentValues = new ContentValues();
        //  contentValues.put("Id", khonggiantiec.Id_khonggiantiec);
        contentValues.put("Ten mon", khonggiantiec.Tenkhonggian);
        contentValues.put("Anh", khonggiantiec.Anh);

        return db.insert("Khonggiantiec", null, contentValues);
    }

    public int update(Khonggiantiec khonggiantiec) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id", khonggiantiec.Id_khonggiantiec);
        contentValues.put("Ten mon", khonggiantiec.Tenkhonggian);
        contentValues.put("Anh", khonggiantiec.Anh);

        return db.update("Khonggiantiec", contentValues, "Id_khonggiantiec=?", new String[]{String.valueOf(khonggiantiec.Id_khonggiantiec)});
    }

    public int delete(String id) {
        return db.delete("Khonggiantiec", "Id_khonggiantiec=?", new String[]{id});
    }

    public List<Khonggiantiec> getAll() {
        String sql = "select * from Khonggiantiec";
        return getData(sql);
    }

    public Khonggiantiec getID(String id) {
        String sql = "select * from Sach where Id_khonggiantiec=?";
        List<Khonggiantiec> list2 = new ArrayList<>();
        list2 = getData(sql, id);
        return list2.get(0);

    }

    @SuppressLint("Range")
    private List<Khonggiantiec> getData(String sql, String... selectionArgs) {
        List<Khonggiantiec> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Khonggiantiec khonggiantiec = new Khonggiantiec();
            khonggiantiec.Id_khonggiantiec = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Id_khonggiantiec")));
            khonggiantiec.Tenkhonggian = cursor.getString(cursor.getColumnIndex("Tenkhonggian"));
            khonggiantiec.Anh = cursor.getString(cursor.getColumnIndex("Anh"));
            khonggiantiec.setReview(cursor.getString(cursor.getColumnIndex("DanhGia")));
            list.add(khonggiantiec);
        }
        return list;
    }
}
