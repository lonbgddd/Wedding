package com.example.wedding.Domain;

public class Thietlap {
    private int Id_thietlap;
    private String Title;
    private String Review;
    private String Anh;

    public Thietlap() {
    }

    public Thietlap(int id_thietlap, String title, String review, String anh) {
        Id_thietlap = id_thietlap;
        Title = title;
        Review = review;
        Anh = anh;
    }

    public int getId_thietlap() {
        return Id_thietlap;
    }

    public void setId_thietlap(int id_thietlap) {
        Id_thietlap = id_thietlap;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }
}
