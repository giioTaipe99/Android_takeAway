package com.example.myapplication;

import java.io.Serializable;

public class OrderProducts implements Serializable {
    private int id;
    private double price;

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
