package com.example.wedding.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wedding.Domain.Tiec;
import com.example.wedding.Helper.Sqldatabase;

import java.util.ArrayList;
import java.util.List;

public class TiecDao {
    private SQLiteDatabase db;

    public TiecDao(Context context) {
        Sqldatabase sqldatabase = new Sqldatabase(context);
        db = sqldatabase.getWritableDatabase();
    }

    public long insert(Tiec tiec) {
        ContentValues contentValues = new ContentValues();
        //   contentValues.put("Id", tiec.Id_tiec);
        contentValues.put("Ten mon", tiec.Tentiec);
        contentValues.put("Anh", tiec.Tenkhonggian);
        contentValues.put("Gia", tiec.Monan);

        return db.insert("Tiec", null, contentValues);
    }

    public int update(Tiec tiec) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id_monan", tiec.Id_tiec);
        contentValues.put("Ten mon", tiec.Tentiec);
        contentValues.put("Anh", tiec.Tenkhonggian);
        contentValues.put("Gia", tiec.Monan);
        return db.update("Tiec", contentValues, "Id_tiec=?", new String[]{String.valueOf(tiec.Id_tiec)});
    }

    public int delete(String id) {
        return db.delete("Tiec", "Id_tiec=?", new String[]{id});
    }

    public List<Tiec> getAll() {
        String sql = "select * from Tiec";
        return getData(sql);
    }

    public Tiec getID(String id) {
        String sql = "select * from Sach where Id_tiec=?";
        List<Tiec> list2 = new ArrayList<>();
        list2 = getData(sql, id);
        return list2.get(0);

    }

    @SuppressLint("Range")
    private List<Tiec> getData(String sql, String... selectionArgs) {
        List<Tiec> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Tiec tiec = new Tiec();
            tiec.Id_tiec = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Id_tiec")));
            tiec.Tentiec = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Tentiec")));
            tiec.Tenkhonggian = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Tenkhonggian")));
            tiec.Monan = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Monan")));
            list.add(tiec);
        }
        return list;
    }
}
