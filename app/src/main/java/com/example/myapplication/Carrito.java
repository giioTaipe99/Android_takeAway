package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Carrito extends AppCompatActivity {

    private List<Products> carritoList;
    private ImageButton btnReturn;
    private OrdersAdapter carritoAdapter;
    private RecyclerView recyclerView;
    public Carrito() {
        // Puedes dejar este constructor vacío o inicializar variables si es necesario
    }
    public Carrito(List<Products> carritoList) {
        this.carritoList = carritoList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        btnReturn = findViewById(R.id.imageButton);
        recyclerView = findViewById(R.id.recyclerViewC);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (carritoList == null) {
            carritoList = new ArrayList<>();
        }
        carritoAdapter = new OrdersAdapter(carritoList);
        recyclerView.setAdapter(carritoAdapter);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnMainActivity();
            }
        });

        Intent intent = getIntent();
        if (intent.hasExtra("Product")) {
            Products product = (Products) intent.getSerializableExtra("Product");
            addToCart(product);
        }
    }

    public void returnMainActivity() {
        Intent intent = new Intent(Carrito.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    // Método para añadir productos al carrito
    public void addToCart(Products product) {
        carritoList.add(product);
        if (carritoAdapter != null) {
            carritoAdapter.notifyDataSetChanged();
        }
        Log.d("Carrito", "Productos en carrito: " + carritoList.size());
    }
}
