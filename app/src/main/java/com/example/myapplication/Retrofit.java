package com.example.myapplication;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private static final String BASE_URL = "http://192.168.16.164:3001/";

    static final retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static InterfaceAPI getApiService() {
        return retrofit.create(InterfaceAPI.class);
    }
}
