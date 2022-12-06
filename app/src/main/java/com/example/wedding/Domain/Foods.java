package com.example.wedding.Domain;

public class Foods {
    public int Id_food;
    public String Name;
    public String Image;
    public String Review;

    public Foods() {
    }

    public Foods(int id_monan, String tenmon, String anh, String gia) {
        Id_food = id_monan;
        Name = tenmon;
        Image = anh;
        Review = gia;
    }

    public int getId_food() {
        return Id_food;
    }

    public void setId_food(int id_food) {
        Id_food = id_food;
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

    public String getReview() {
        return Review;
    }

    public void setReview(String review) {
        Review = review;
    }
}
