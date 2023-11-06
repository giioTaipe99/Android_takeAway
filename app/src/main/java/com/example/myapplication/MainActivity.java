package com.example.myapplication;

import static com.example.myapplication.Retrofit.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        productAdapter = new ProductAdapter();
        recyclerView.setAdapter(productAdapter);
        InterfaceAPI apiService = Retrofit.getApiService();

        Call<List<Products>> call = apiService.getProducts();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if (response.isSuccessful()){
                    List<Products> products = response.body();

                    productAdapter.setProducts(products);
                    Log.d("Resultado API", "Cuerpo de la respuesta:");

                    for (Products product : products) {
                        Log.d("Producto", product.toString());
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.d("falla", "falla productos");
            }

        });

    }
    /*public void profile(View view){
        Intent intent = new Intent(MainActivity.this,Profile.class);
        startActivity(intent);
    }*/
}