package com.example.wedding.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wedding.Domain.Foods;
import com.example.wedding.Helper.Sqldatabase;

import java.util.ArrayList;
import java.util.List;

public class MonanDao {
    private SQLiteDatabase db;

    public MonanDao(Context context) {
        Sqldatabase sqldatabase = new Sqldatabase(context);
        db = sqldatabase.getWritableDatabase();
    }

    public long insert(Foods monan) {
        ContentValues contentValues = new ContentValues();
           contentValues.put("Id_food", monan.Id_food);
        contentValues.put("Name", monan.Name);
        contentValues.put("Image", monan.Image);
        contentValues.put("Review", monan.Review);

        return db.insert("Foods", null, contentValues);
    }

    public int delete(String id) {
        return db.delete("Foods", "Id_food=?", new String[]{id});
    }

    public List<Foods> getAll() {
        String sql = "SELECT * FROM Foods";
        return getData(sql);
    }

    @SuppressLint("Range")
    private List<Foods> getData(String sql, String... selectionArgs) {
        List<Foods> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Foods monan = new Foods();
            monan.Id_food = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Id_food")));
            monan.Name = cursor.getString(cursor.getColumnIndex("Name"));
            monan.Image = cursor.getString(cursor.getColumnIndex("Image"));
            monan.Review = cursor.getString(cursor.getColumnIndex("Review"));
            list.add(monan);
        }
        return list;
    }
}
