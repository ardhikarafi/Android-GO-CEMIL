package com.example.ino.cemilanrafiku;

import android.support.v7.app.AppCompatActivity;

public class Cemilan extends AppCompatActivity {
    private int image;
    private String name;
    private double price;

    public Cemilan(int image, String name, double price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

