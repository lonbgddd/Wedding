package com.example.wedding.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        String createTableMonan = "create table Foods(" +
                "Id_food INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT NOT NULL," +
                "Image TEXT NOT NULL," +
                "Review TEXT NOT NULL)";
        db.execSQL(createTableMonan);

        String createTableKhonggiantiec = "create table Space(" +
                "Id_space INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT NOT NULL," +
                "Review TEXT NOT NULL," +
                "Image TEXT NOT NULL)";
        db.execSQL(createTableKhonggiantiec);

        String createTableDichvu = "create table Service(" +
                "Id_service INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT NOT NULL," +
                "Review TEXT NOT NULL," +
                "Date TEXT NOT NULL," +
                "Image TEXT NOT NULL)";
        db.execSQL(createTableDichvu);

        String createThietlap = "create table Thietlap(" +
                "Id_thietlap INTEGER PRIMARY KEY ," +
                "Title INTEGER NOT NULL," +
                "Review TEXT NOT NULL," +
                "Anh TEXT NOT NULL)";
        db.execSQL(createThietlap);

//        String createLuutamthoi = "create table DanhSach(" +
//                "Id_danhSach INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "Title INTEGER NOT NULL," +
//                "Review TEXT NOT NULL," +
//                "Anh TEXT NOT NULL)";
//        db.execSQL(createLuutamthoi);

        createTableMonan = "INSERT INTO  Foods   VALUES ( 1 ,'Nguyễn Phi Long','2131165377','Tốt')";
        db.execSQL(createTableMonan);
        createTableMonan = "INSERT INTO  Foods   VALUES ( 2 ,'Chu van huy','2131165378','Khá')";
        db.execSQL(createTableMonan);
        createTableMonan = "INSERT INTO  Foods   VALUES ( 3 ,'Nguyễn Hoang Anh','2131165379','Trung bình')";
        db.execSQL(createTableMonan);

        createTableKhonggiantiec = "INSERT INTO  Space   VALUES ( 1 ,'Nguyễn Phi Long','aaa','2131165321')";
        db.execSQL(createTableKhonggiantiec);
        createTableKhonggiantiec = "INSERT INTO  Space   VALUES ( 2 ,'Chu van huy','bbbb','2131165323')";
        db.execSQL(createTableKhonggiantiec);
        createTableKhonggiantiec = "INSERT INTO  Space   VALUES ( 3 ,'Nguyễn Hoang Anh','cccc','2131165325')";
        db.execSQL(createTableKhonggiantiec);
        createTableKhonggiantiec = "INSERT INTO  Space   VALUES ( 4 ,'Nguyễn Hoang Anh','cccc','2131165325')";
        db.execSQL(createTableKhonggiantiec);

        createTableDichvu = "INSERT INTO  Service  VALUES ( 1 ,'Dam cuoi','sảnh lớn','122222','2131165325')";
        db.execSQL(createTableDichvu);
        createTableDichvu = "INSERT INTO  Service   VALUES ( 2 ,'Le hoi','Hội trường','taiaiaiai','2131165327')";
        db.execSQL(createTableDichvu);
        createTableDichvu = "INSERT INTO  Service   VALUES ( 3 ,'Sinh nhật','Hội trường','taiaiaiai','2131165408')";
        db.execSQL(createTableDichvu);
        createTableDichvu = "INSERT INTO  Service   VALUES ( 4 ,'Vịt Bắc Kinh','Bạn ăn thử chưa','taiaiaiai','2131165407')";
        db.execSQL(createTableDichvu);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}