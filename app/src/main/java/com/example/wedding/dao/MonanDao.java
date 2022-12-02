package com.example.wedding.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wedding.Domain.Monan;
import com.example.wedding.Helper.Sqldatabase;

import java.util.ArrayList;
import java.util.List;

public class MonanDao {
    private SQLiteDatabase db;

    public MonanDao(Context context) {
        Sqldatabase sqldatabase = new Sqldatabase(context);
        db = sqldatabase.getWritableDatabase();
    }

    public long insert(Monan monan) {
        ContentValues contentValues = new ContentValues();
        //   contentValues.put("Id", monan.Id_monan);
        contentValues.put("Ten mon", monan.Tenmon);
        contentValues.put("Anh", monan.Anh);
        contentValues.put("Gia", monan.Gia);

        return db.insert("Monan", null, contentValues);
    }

    public int update(Monan monan) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id", monan.Id_monan);
        contentValues.put("Ten mon", monan.Tenmon);
        contentValues.put("Anh", monan.Anh);
        contentValues.put("Gia", monan.Gia);
        return db.update("Monan", contentValues, "Id_monan=?", new String[]{String.valueOf(monan.Id_monan)});
    }

    public int delete(String id) {
        return db.delete("Monan", "Id_monan=?", new String[]{id});
    }

    public List<Monan> getAll() {
        String sql = "select * from Monan";
        return getData(sql);
    }

    public Monan getID(String id) {
        String sql = "select * from Sach where Id_monan=?";
        List<Monan> list2 = new ArrayList<>();
        list2 = getData(sql, id);
        return list2.get(0);

    }

    @SuppressLint("Range")
    private List<Monan> getData(String sql, String... selectionArgs) {
        List<Monan> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Monan monan = new Monan();
            monan.Id_monan = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Id_monan")));
            monan.Tenmon = cursor.getString(cursor.getColumnIndex("Tenmon"));
            monan.Anh = cursor.getString(cursor.getColumnIndex("Anh"));
            monan.Gia = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Gia")));
            list.add(monan);
        }
        return list;
    }
}
