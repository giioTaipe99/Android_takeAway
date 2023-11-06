package com.example.myapplication;

import java.io.Serializable;

public class Products implements Serializable {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String imageUrl;

    public Products(int id, String name, String description, double price, int stock, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getImgUrl() {
        return imageUrl;
    }

}