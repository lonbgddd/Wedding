package com.example.wedding.Domain;

public class Khonggiantiec {
    public int Id_khonggiantiec;
    public String Tenkhonggian;
    public String Review;
    public String Anh;

    public Khonggiantiec(int id_khonggiantiec, String tenkhonggian,String Review, String anh) {
        Id_khonggiantiec = id_khonggiantiec;
        Tenkhonggian = tenkhonggian;
        Anh = anh;
        this.Review =Review;
    }

    public Khonggiantiec() {
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
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
