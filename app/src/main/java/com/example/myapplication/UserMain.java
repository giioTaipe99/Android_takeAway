package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserMain extends AppCompatActivity {

    private EditText username;
    private EditText password;
    Users usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InterfaceAPI apiService = Retrofit.getApiService();

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.botonLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameText = username.getText().toString();
                String passwordText = password.getText().toString();
                usuario = new Users(usernameText, passwordText);
                Call<Void> call = apiService.verifyUser(usuario);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful()) {
                            // Éxito, la solicitud se envió correctamente
                            String msg = "Bienvenido "+usernameText;

                            // Muestra el mensaje en un Toast o en algún otro lugar de la interfaz de usuario
                            Toast.makeText(UserMain.this, msg, Toast.LENGTH_SHORT).show();

                            // Éxito, la solicitud se envió correctamente
                            Intent intent = new Intent(UserMain.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            String msg = "Usuario no encontrado";
                            Toast.makeText(UserMain.this, msg, Toast.LENGTH_SHORT).show();
                            // Error en la respuesta del servidor
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.e("Error", "Error en la conexión: " + t.getMessage());
                    }
                });
            }
        });
    }
}