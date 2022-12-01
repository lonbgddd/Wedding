package com.example.wedding.Domain;

import java.security.IdentityScope;

public class Popular {
    private int id;
    private String Title;
    private String Description;
    private int img;
    private int numberInCart;

    public Popular(int id, String title, String description, int img) {
        this.id = id;
        Title = title;
        Description = description;
        this.img = img;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
