package com.example.felizmarket;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.felizmarket.db.AppDatabase;
import com.example.felizmarket.db.CartItem;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        String name = getIntent().getExtras().getString("name");
        String price = getIntent().getExtras().getString("price");
        String img =  getIntent().getExtras().getString("img");


        final AppDatabase db = Room.databaseBuilder(getApplicationContext()
                ,AppDatabase.class ,"production")
                .allowMainThreadQueries()
                .build();

        db.cartDao().insertAll(new CartItem(name, price , img));
    }
}
