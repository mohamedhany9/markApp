package com.example.felizmarket.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CartDao {

    @Query("SELECT * FROM cartitem")
    List<CartDao> getAllIem();

    @Insert
    void insertAll(CartItem... cartItems);
}
