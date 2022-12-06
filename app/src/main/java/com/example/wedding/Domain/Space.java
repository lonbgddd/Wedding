package com.example.wedding.Domain;

public class Space {
    public int Id_space;
    public String Name;
    public String Review;
    public String Image;

    public Space(int id_khonggiantiec, String tenkhonggian, String Review, String anh) {
        Id_space = id_khonggiantiec;
        Name = tenkhonggian;
        Image = anh;
        this.Review =Review;
    }

    public Space() {
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }

    public int getId_space() {
        return Id_space;
    }

    public void setId_space(int id_space) {
        Id_space = id_space;
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
}
