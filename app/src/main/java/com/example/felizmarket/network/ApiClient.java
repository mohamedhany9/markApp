package com.example.felizmarket.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final  String BASE_URL = "http://204.93.167.45/~helix/";
    public static Retrofit retrofit ;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
