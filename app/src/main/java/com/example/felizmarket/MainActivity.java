package com.example.felizmarket;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.felizmarket.adapter.AdapterItem;
import com.example.felizmarket.adapter.AdapterItemGrid;
import com.example.felizmarket.db.AppDatabase;
import com.example.felizmarket.db.CartItem;
import com.example.felizmarket.model.ProductsResponse;
import com.example.felizmarket.network.ApiClient;
import com.example.felizmarket.network.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager2;
    private AdapterItem adapter;
    private AdapterItemGrid gadapter;
    private ImageView gridBtn , listBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        gridBtn = findViewById(R.id.gridlayout_btn);
        listBtn = findViewById(R.id.listlayout_btn);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        ApiInterface apiInterface = ApiClient.getRetrofitClient().create(ApiInterface.class);

        Call<ArrayList<ProductsResponse>> call = apiInterface.getcart();
        call.enqueue(new Callback<ArrayList<ProductsResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductsResponse>> call, Response<ArrayList<ProductsResponse>> response) {

                ArrayList<ProductsResponse> carts = response.body();
                adapter = new AdapterItem(MainActivity.this, carts);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArrayList<ProductsResponse>> call, Throwable t) {

            }
        });

        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutManager2 = new GridLayoutManager(MainActivity.this,2);
                recyclerView.setLayoutManager(layoutManager2);
                recyclerView.setHasFixedSize(true);


                ApiInterface apiInterface = ApiClient.getRetrofitClient().create(ApiInterface.class);

                Call<ArrayList<ProductsResponse>> call = apiInterface.getcart();
                call.enqueue(new Callback<ArrayList<ProductsResponse>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ProductsResponse>> call, Response<ArrayList<ProductsResponse>> response) {

                        ArrayList<ProductsResponse> carts = response.body();
                        gadapter = new AdapterItemGrid(MainActivity.this, carts);
                        recyclerView.setAdapter(gadapter);

                    }

                    @Override
                    public void onFailure(Call<ArrayList<ProductsResponse>> call, Throwable t) {

                    }
                });


            }
        });

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setHasFixedSize(true);

                ApiInterface apiInterface = ApiClient.getRetrofitClient().create(ApiInterface.class);

                Call<ArrayList<ProductsResponse>> call = apiInterface.getcart();
                call.enqueue(new Callback<ArrayList<ProductsResponse>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ProductsResponse>> call, Response<ArrayList<ProductsResponse>> response) {

                        ArrayList<ProductsResponse> carts = response.body();
                        adapter = new AdapterItem(MainActivity.this, carts);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(Call<ArrayList<ProductsResponse>> call, Throwable t) {

                    }
                });


            }
        });

        final AppDatabase db = Room.databaseBuilder(getApplicationContext()
                ,AppDatabase.class ,"production")
                .allowMainThreadQueries()
                .build();



    }
}
