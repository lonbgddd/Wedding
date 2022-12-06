package com.example.wedding.Domain;

public class Service {
    public int Id_service;
    public String Review;
    public String date;
    public String Name;
    public String Image;

    public Service() {
    }

    public Service(int id_dichvu, String khonggiantiec, String ten, String anh) {
        Id_service = id_dichvu;
        Review = khonggiantiec;
        Name = ten;
        Image = anh;
    }

    public int getId_service() {
        return Id_service;
    }

    public void setId_service(int id_service) {
        Id_service = id_service;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
