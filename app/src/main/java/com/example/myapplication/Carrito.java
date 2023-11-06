package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Carrito extends AppCompatActivity {

    private Products product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        Intent intent = getIntent();
        if(intent.hasExtra("Product")) {
            product = (Products) intent.getSerializableExtra("Product");
        }
    }
}