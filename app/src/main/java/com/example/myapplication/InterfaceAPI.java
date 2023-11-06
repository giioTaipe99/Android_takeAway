package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InterfaceAPI {
    @POST("http://192.168.16.185:3001/verify")
    Call<Void> verifyUser(@Body Users usuario);
    @GET("http://192.168.16.185:3001/getProducts")
    Call<List<Products>> getProducts();
    @GET("http://192.168.16.185:3001/getUserDetails")
    Call<UserDetails> getUserDetails();
}
