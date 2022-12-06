package com.example.wedding.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.wedding.Domain.Service;
import com.example.wedding.Helper.Sqldatabase;

import java.util.ArrayList;
import java.util.List;

public class DichvuDao {
    private SQLiteDatabase db;

    public DichvuDao(Context context) {
        Sqldatabase sqldatabase = new Sqldatabase(context);
        db = sqldatabase.getWritableDatabase();
    }

    public long insert(Service dichvu) {
        ContentValues contentValues = new ContentValues();
        //   contentValues.put("Id", monan.Id_monan);
        contentValues.put("Ten khong gian", dichvu.Review);
        contentValues.put("Ten", dichvu.Name);
        contentValues.put("Anh", dichvu.Image);

        return db.insert("Service", null, contentValues);
    }

//    public int update(Service dichvu) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("Id_dichvu", dichvu.Id_service);
//        contentValues.put("Tenkhonggian", dichvu.Review);
//        contentValues.put("Ten", dichvu.Name);
//        contentValues.put("Anh", dichvu.Image);
//        return db.update("Service", contentValues, "Id_dichvu=?", new String[]{String.valueOf(dichvu.Id_service)});
//    }

//    public int delete(String id) {
//        return db.delete("Service", "Id_dichvu=?", new String[]{id});
//    }

    public List<Service> getAll() {
        String sql = "select * from Service";
        return getData(sql);
    }

//    public Service getID(String id) {
//        String sql = "select * from Sach where Id_dichvu=?";
//        List<Service> list2 = new ArrayList<>();
//        list2 = getData(sql, id);
//        return list2.get(0);
//
//    }

    @SuppressLint("Range")
    private List<Service> getData(String sql, String... selectionArgs) {
        List<Service> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Service dichvu = new Service();
            dichvu.Id_service = Integer.parseInt(cursor.getString(cursor.getColumnIndex("Id_service")));
            dichvu.Review = cursor.getString(cursor.getColumnIndex("Review"));
            dichvu.Name = cursor.getString(cursor.getColumnIndex("Name"));
            dichvu.date = cursor.getString(cursor.getColumnIndex("Date"));
            dichvu.Image = cursor.getString(cursor.getColumnIndex("Image"));
            list.add(dichvu);
        }
        return list;
    }
}
