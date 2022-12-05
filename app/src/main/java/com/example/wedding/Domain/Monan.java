package com.example.wedding.Domain;

public class Monan {
    public int Id_monan;
    public String Tenmon;
    public String Anh;
    public String DanhGia;

    public Monan() {
    }

    public Monan(int id_monan, String tenmon, String anh, String gia) {
        Id_monan = id_monan;
        Tenmon = tenmon;
        Anh = anh;
        DanhGia = gia;
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

    public String getDanhGia() {
        return DanhGia;
    }

    public void setDanhGia(String danhGia) {
        DanhGia = danhGia;
    }
}
