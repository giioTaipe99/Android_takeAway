package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Products;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.CarritoViewHolder> {

    private List<Products> carritoList;

    public OrdersAdapter(List<Products> carritoList) {
        this.carritoList = carritoList;
    }

    @NonNull
    @Override
    public CarritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Asegúrate de crear una nueva instancia de CarritoViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrito, parent, false);
        return new CarritoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoViewHolder holder, int position) {
        Products product = carritoList.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return carritoList != null ? carritoList.size() : 0;
    }

    public class CarritoViewHolder extends RecyclerView.ViewHolder {
        private ImageView orderImg;
        private TextView productNameTextView;
        private TextView quantityTextView;
        private TextView priceProductTextView;

        public CarritoViewHolder(@NonNull View itemView) {
            super(itemView);
            orderImg = itemView.findViewById(R.id.imgProductC);
            productNameTextView = itemView.findViewById(R.id.nameProdcut);
            quantityTextView = itemView.findViewById(R.id.quantity);
            priceProductTextView = itemView.findViewById(R.id.priceProduct);
        }

        public void bind(Products product) {
            Log.d("CarritoViewHolder", "Binding product: " + product.getName());
            Picasso.get().load(product.getImgUrl()).into(orderImg);

            if (productNameTextView != null) {
                productNameTextView.setText(product.getName());
            }

            if (quantityTextView != null) {
                quantityTextView.setText("Cantidad: 1");
            }

            if (priceProductTextView != null) {
                String priceText = String.valueOf(product.getPrice());
                priceProductTextView.setText(priceText);
            }
        }
    }
}


