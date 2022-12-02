package com.example.wedding.Domain;

public class Khonggiantiec {
    public int Id_khonggiantiec;
    public String Tenkhonggian;
    public String Anh;

    public Khonggiantiec(int id_khonggiantiec, String tenkhonggian, String anh) {
        Id_khonggiantiec = id_khonggiantiec;
        Tenkhonggian = tenkhonggian;
        Anh = anh;
    }

    public Khonggiantiec() {
    }

    public int getId_khonggiantiec() {
        return Id_khonggiantiec;
    }

    public void setId_khonggiantiec(int id_khonggiantiec) {
        Id_khonggiantiec = id_khonggiantiec;
    }

    public String getTenkhonggian() {
        return Tenkhonggian;
    }

    public void setTenkhonggian(String tenkhonggian) {
        Tenkhonggian = tenkhonggian;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }
}
