package com.example.wedding.Domain;

public class Tiec {
    public int Id_tiec;
    public int Tentiec;
    public int Tenkhonggian;
    public int Monan;

    public Tiec() {
    }

    public Tiec(int id_tiec, int tentiec, int tenkhonggian, int monan) {
        Id_tiec = id_tiec;
        Tentiec = tentiec;
        Tenkhonggian = tenkhonggian;
        Monan = monan;
    }

    public int getId_tiec() {
        return Id_tiec;
    }

    public void setId_tiec(int id_tiec) {
        Id_tiec = id_tiec;
    }

    public int getTentiec() {
        return Tentiec;
    }

    public void setTentiec(int tentiec) {
        Tentiec = tentiec;
    }

    public int getTenkhonggian() {
        return Tenkhonggian;
    }

    public void setTenkhonggian(int tenkhonggian) {
        Tenkhonggian = tenkhonggian;
    }

    public int getMonan() {
        return Monan;
    }

    public void setMonan(int monan) {
        Monan = monan;
    }
}
