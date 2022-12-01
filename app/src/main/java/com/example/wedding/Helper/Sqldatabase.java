package com.example.wedding.Helper;

import static java.sql.Types.NULL;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Sqldatabase extends SQLiteOpenHelper {

    public static final String dbName = "wedding.db";
    public static final int dbVersion = 1;

    public Sqldatabase(Context context) {
        super(context, dbName, null, dbVersion);
    }

    SQLiteDatabase db = getReadableDatabase();

    //Khi cần cập nhật dữ liệu (CREATE, DELETE, UPDATE, INSERT)
    SQLiteDatabase db1 = getWritableDatabase();

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableMonan = "create table Monan(" +
                "Id_monan INTEGER not null  PRIMARY KEY," +
                "TenMon TEXT NOT NULL," +
                "Anh TEXT NOT NULL," +
                "Gia INTEGER NOT NULL)";
        db.execSQL(createTableMonan);

        String createTableKhonggiantiec = "create table Khonggiantiec(" +
                "Id_khonggiantiec INTEGER not null  PRIMARY KEY," +
                "Tenkhonggian TEXT NOT NULL," +
                "Anh TEXT NOT NULL)";
        db.execSQL(createTableKhonggiantiec);

        String createTableDichvu = "create table Dichvu(" +
                " Id_dichvu INTEGER not null  PRIMARY KEY," +
                "Khonggiantiec INTEGER NOT NULL," +
                "Ten TEXT NOT NULL," +
                "Anh TEXT NOT NULL)";
        db.execSQL(createTableDichvu);

        String createTableTiec = "create table Tiec(" +
                " Id_tiec INTEGER not null  PRIMARY KEY," +
                "Tentiec INTEGER NOT NULL," +
                "Tenkhonggian INTEGER NOT NULL," +
                "Monan INTEGER NOT NULL)";
        db.execSQL(createTableTiec);

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
