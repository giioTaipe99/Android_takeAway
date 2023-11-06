package com.example.myapplication;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Products> products;
    public void setProducts(List<Products> products) {

        this.products = products;
        notifyDataSetChanged(); // Notifica al adaptador que los datos han cambiado
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el diseño del elemento de la lista y crea un ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        // Vincula los datos en la posición específica con el ViewHolder
        Products product = products.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        // Devuelve la cantidad de elementos en la lista
        return products != null ? products.size() : 0;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        // Define las vistas dentro de cada elemento de la lista
        private ImageView productImg;
        private TextView productNameTextView;
        private TextView productDescriptionTextView;
        private TextView priceProduct;
        private Button btnAfegir;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImg = itemView.findViewById(R.id.imgProduct);
            productNameTextView = itemView.findViewById(R.id.nameProduct);
            productDescriptionTextView = itemView.findViewById(R.id.description);
            priceProduct = itemView.findViewById(R.id.price);
            btnAfegir = itemView.findViewById(R.id.btn);
        }

        public void bind(Products product) {
            // Vincula los datos del producto con las vistas
            Picasso.get().load(product.getImgUrl()).into(productImg);
            Log.d("msg", "URL de la imagen: " + product.getImgUrl());
            productNameTextView.setText(product.getName());
            productDescriptionTextView.setText(product.getDescription());
            priceProduct.setText("Preu: " + String.valueOf(product.getPrice())+"€");
            btnAfegir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), Carrito.class);
                    intent.putExtra("Product", product);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
