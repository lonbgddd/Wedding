package com.example.wedding.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.wedding.Domain.Monan;

public class Sqldatabase extends SQLiteOpenHelper {

    public static final String dbName = "wedding.db";
    public static final int dbVersion = 3;

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
                "Ten TEXT NOT NULL," +
                "DanhGia TEXT NOT NULL," +
                "Anh TEXT NOT NULL)";
        db.execSQL(createTableDichvu);

        String createThietlap = "create table Thietlap(" +
                "Id_thietlap INTEGER PRIMARY KEY ," +
                "Title INTEGER NOT NULL," +
                "Review TEXT NOT NULL," +
                "Anh TEXT NOT NULL)";
        db.execSQL(createThietlap);

        String createLuutamthoi = "create table DanhSach(" +
                "Id_danhSach INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Title INTEGER NOT NULL," +
                "Review TEXT NOT NULL," +
                "Anh TEXT NOT NULL)";
        db.execSQL(createLuutamthoi);

        createTableMonan = "INSERT INTO  Monan   VALUES ( 1 ,'Nguyễn Phi Long','2131165451' ,'Tốt')";
        db.execSQL(createTableMonan);
        createTableMonan = "INSERT INTO  Monan   VALUES ( 2 ,'Chu van huy','2131165452' ,'Khá')";
        db.execSQL(createTableMonan);
        createTableMonan = "INSERT INTO  Monan   VALUES ( 3 ,'Nguyễn Hoang Anh','2131165453','Trung bình')";
        db.execSQL(createTableMonan);

        createTableKhonggiantiec = "INSERT INTO  Khonggiantiec   VALUES ( 1 ,'Nguyễn Phi Long','aaa','2131165411')";
        db.execSQL(createTableKhonggiantiec);
        createTableKhonggiantiec = "INSERT INTO  Khonggiantiec   VALUES ( 2 ,'Chu van huy','bbbb','2131165412')";
        db.execSQL(createTableKhonggiantiec);
        createTableKhonggiantiec = "INSERT INTO  Khonggiantiec   VALUES ( 3 ,'Nguyễn Hoang Anh','cccc','2131165413')";
        db.execSQL(createTableKhonggiantiec);
        createTableKhonggiantiec = "INSERT INTO  Khonggiantiec   VALUES ( 4 ,'Nguyễn Hoang Anh','cccc','2131165414')";
        db.execSQL(createTableKhonggiantiec);

        createTableDichvu = "INSERT INTO  Dichvu  VALUES ( 1 ,'Dam cuoi','sảnh lớn' ,'2131165315')";
        db.execSQL(createTableDichvu);
        createTableDichvu = "INSERT INTO  Dichvu   VALUES ( 2 ,'Le hoi','Hội trường' ,'2131165316')";
        db.execSQL(createTableDichvu);
//        createTableDichvu = "INSERT INTO  Dichvu   VALUES ( 3 ,'tot nghiep','Trường học','Khá' )";
//        db.execSQL(createTableDichvu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}