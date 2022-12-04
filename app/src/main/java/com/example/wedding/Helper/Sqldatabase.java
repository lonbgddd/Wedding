package com.example.wedding.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.wedding.Domain.Monan;

public class Sqldatabase extends SQLiteOpenHelper {

    public static final String dbName = "wedding.db";
    public static final int dbVersion = 1;


    public Sqldatabase(Context context) {
        super(context, dbName, null, dbVersion);
    }

    //Khi cần cập nhật dữ liệu (CREATE, DELETE, UPDATE, INSERT)
    SQLiteDatabase db1 = getWritableDatabase();
    SQLiteDatabase db2 = getReadableDatabase();

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableMonan = "create table Monan(" +
                "Id_monan INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TenMon TEXT NOT NULL," +
                "Anh TEXT NOT NULL," +
                "DanhGia TEXT NOT NULL)";
        db.execSQL(createTableMonan);

        String createTableKhonggiantiec = "create table Khonggiantiec(" +
                "Id_khonggiantiec INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Tenkhonggian TEXT NOT NULL," +
                "DanhGia TEXT NOT NULL," +
                "Anh TEXT NOT NULL)";
        db.execSQL(createTableKhonggiantiec);

        String createTableDichvu = "create table Dichvu(" +
                "Id_dichvu INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Khonggiantiec INTEGER NOT NULL," +
                "Ten TEXT NOT NULL," +
                "DanhGia TEXT NOT NULL," +
                "Anh TEXT NOT NULL)";
        db.execSQL(createTableDichvu);

        String createTableTiec = "create table Tiec(" +
                "Id_tiec INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Tentiec INTEGER NOT NULL," +
                "Tenkhonggian INTEGER NOT NULL," +
                "DanhGia TEXT NOT NULL," +
                "Monan INTEGER NOT NULL)";
        db.execSQL(createTableTiec);

        String createThietlap = "create table Thietlap(" +
                "Id_thietlap INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Title INTEGER NOT NULL," +
                "Review TEXT NOT NULL)";
        db.execSQL(createThietlap);

        String createLuutamthoi = "create table Luutamthoi(" +
                "Id_luutamthoi INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Title INTEGER NOT NULL," +
                "Review TEXT NOT NULL)";
        db.execSQL(createLuutamthoi);


        createTableMonan = "INSERT INTO  Monan   VALUES ( 1 ,'Nguyễn Phi Long','anh1' ,'Tốt')";
        db.execSQL(createTableMonan);
        createTableMonan = "INSERT INTO  Monan   VALUES ( 2 ,'Chu van huy','anh2' ,'Khá')";
        db.execSQL(createTableMonan);
        createTableMonan = "INSERT INTO  Monan   VALUES ( 3 ,'Nguyễn Hoang Anh','anh3','Trung bình')";
        db.execSQL(createTableMonan);

        createTableKhonggiantiec = "INSERT INTO  Khonggiantiec   VALUES ( 1 ,'Nguyễn Phi Long','aaa','image 1')";
        db.execSQL(createTableKhonggiantiec);
        createTableKhonggiantiec = "INSERT INTO  Khonggiantiec   VALUES ( 2 ,'Chu van huy','bbbb','image 2')";
        db.execSQL(createTableKhonggiantiec);
        createTableKhonggiantiec = "INSERT INTO  Khonggiantiec   VALUES ( 3 ,'Nguyễn Hoang Anh','cccc','image 3')";
        db.execSQL(createTableKhonggiantiec);

        createTableDichvu = "INSERT INTO  Dichvu  VALUES ( 1 ,'Dam cuoi','sảnh lớn' ,'Tốt','Bánh')";
        db.execSQL(createTableDichvu);
        createTableDichvu = "INSERT INTO  Dichvu   VALUES ( 2 ,'Le hoi','Hội trường' ,'Khá','Kẹo')";
        db.execSQL(createTableDichvu);
        createTableDichvu = "INSERT INTO  Dichvu   VALUES ( 3 ,'tot nghiep','Trường học','Khá' ,'Nước')";
        db.execSQL(createTableDichvu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String dropTableMonan = "drop table if exists Monan";
        db.execSQL(dropTableMonan);

        String dropTableKhonggiantiec = "drop table if exists Khonggiantiec";
        db.execSQL(dropTableKhonggiantiec);

        String dropTableDichvu = "drop table if exists Dichvu";
        db.execSQL(dropTableDichvu);

        String dropTableTiec = "drop table if exists Tiec";
        db.execSQL(dropTableTiec);

    }

}