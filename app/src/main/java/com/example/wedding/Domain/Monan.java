package com.example.wedding.Domain;

public class Monan {
    public int Id_monan;
    public String Tenmon;
    public String Anh;
    public int Gia;

    public Monan() {
    }

    public Monan(int id_monan, String tenmon, String anh, int gia) {
        Id_monan = id_monan;
        Tenmon = tenmon;
        Anh = anh;
        Gia = gia;
    }

    public int getId_monan() {
        return Id_monan;
    }

    public void setId_monan(int id_monan) {
        Id_monan = id_monan;
    }

    public String getTenmon() {
        return Tenmon;
    }

    public void setTenmon(String tenmon) {
        Tenmon = tenmon;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }
}
