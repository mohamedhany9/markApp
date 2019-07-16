package com.example.felizmarket.network;

import com.example.felizmarket.model.ProductsResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("items_with_cat_or_subcat/ar/9")
    Call<ArrayList<ProductsResponse>> getcart();
}
