package com.example.wedding.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wedding.Domain.Space;
import com.example.wedding.Helper.Sqldatabase;

import java.util.ArrayList;
import java.util.List;

public class KhonggiantiecDao {
    private SQLiteDatabase db;

    public KhonggiantiecDao(Context context) {
        Sqldatabase sqldatabase = new Sqldatabase(context);
        db = sqldatabase.getWritableDatabase();
    }

    public long insert(Space khonggiantiec) {
        ContentValues contentValues = new ContentValues();
        //  contentValues.put("Id", khonggiantiec.Id_khonggiantiec);
        contentValues.put("Ten mon", khonggiantiec.Name);
        contentValues.put("Anh", khonggiantiec.Image);

        return db.insert("Space", null, contentValues);
    }

    public int update(Space khonggiantiec) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id", khonggiantiec.Id_space);
        contentValues.put("Ten mon", khonggiantiec.Name);
        contentValues.put("Anh", khonggiantiec.Image);

        return db.update("Space", contentValues, "Id_khonggiantiec=?", new String[]{String.valueOf(khonggiantiec.Id_space)});
    }

    public int delete(String id) {
        return db.delete("Space", "Id_khonggiantiec=?", new String[]{id});
    }

    public List<Space> getAll() {
        String sql = "select * from Space";
        return getData(sql);
    }
//
//    public Space getID(String id) {
//        String sql = "select * from Sach where Id_khonggiantiec=?";
//        List<Space> list2 = new ArrayList<>();
//        list2 = getData(sql, id);
//        return list2.get(0);
//
//    }

    @SuppressLint("Range")
    private List<Space> getData(String sql, String... selectionArgs) {
        List<Space> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Space khonggiantiec = new Space();
            khonggiantiec.Id_space = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Id_space")));
            khonggiantiec.Name = cursor.getString(cursor.getColumnIndex("Name"));
            khonggiantiec.Image = cursor.getString(cursor.getColumnIndex("Image"));
            khonggiantiec.setReview(cursor.getString(cursor.getColumnIndex("Review")));
            list.add(khonggiantiec);
        }
        return list;
    }
}
