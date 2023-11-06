package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {

    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView mailTextView;
    private TextView bankDetailsTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Inicializa tus vistas
        firstNameTextView = findViewById(R.id.firtsName);
        lastNameTextView = findViewById(R.id.lastName);
        mailTextView = findViewById(R.id.mail);
        bankDetailsTextView = findViewById(R.id.bankDetails);
        // Llama a la función para obtener detalles del usuario
        getUserDetails();
    }

    private void getUserDetails() {
        InterfaceAPI apiService = Retrofit.getApiService();

        // Hace la llamada a la API para obtener detalles del usuario
        Call<UserDetails> call = apiService.getUserDetails();
        call.enqueue(new Callback<UserDetails>() {
            @Override
            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                if (response.isSuccessful()) {
                    // Obtiene los detalles del usuario
                    UserDetails userDetails = response.body();

                    // Muestra los detalles en las vistas
                    firstNameTextView.setText(userDetails.getFirstName());
                    lastNameTextView.setText(userDetails.getLastName());
                    mailTextView.setText(userDetails.getMail());
                    bankDetailsTextView.setText(userDetails.getBankDetails());
                }
            }

            @Override
            public void onFailure(Call<UserDetails> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
    public void homePage(View view){
        Intent intent = new Intent(Profile.this,MainActivity.class);
        startActivity(intent);
    }

}

