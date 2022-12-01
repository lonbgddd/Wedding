package com.example.wedding.Domain;

public class Dichvu {
    public int Id_dichvu;
    public String Khonggiantiec;
    public String Ten;
    public String Anh;

    public Dichvu() {
    }

    public Dichvu(int id_dichvu, String khonggiantiec, String ten, String anh) {
        Id_dichvu = id_dichvu;
        Khonggiantiec = khonggiantiec;
        Ten = ten;
        Anh = anh;
    }

    public int getId_dichvu() {
        return Id_dichvu;
    }

    public void setId_dichvu(int id_dichvu) {
        Id_dichvu = id_dichvu;
    }

    public String getKhonggiantiec() {
        return Khonggiantiec;
    }

    public void setKhonggiantiec(String khonggiantiec) {
        Khonggiantiec = khonggiantiec;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }
}
