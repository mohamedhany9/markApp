package com.example.felizmarket.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.felizmarket.R;
import com.example.felizmarket.ShoppingActivity;
import com.example.felizmarket.model.ProductsResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.MyViewHolder> {

    private Gson gson = new Gson();
    private SharedPreferences shared;
    private SharedPreferences.Editor sharededitor;
    private String json = "";
    private String retrivedata = "";

    private Context mContext;
    private ArrayList<ProductsResponse> mData;

    public AdapterItem(Context mContext, ArrayList<ProductsResponse> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cart_item_layout, parent, false);

        final MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shared = mContext.getSharedPreferences("market", Context.MODE_PRIVATE);
                sharededitor = shared.edit();
                json = gson.toJson(mData);
                sharededitor.putString("Market", json);
                sharededitor.commit();

                Toast.makeText(mContext, "Success", Toast.LENGTH_SHORT).show();

            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(mData.get(0).getItems().get(position).getName());
        holder.price.setText(mData.get(0).getItems().get(position).getPrice());

        Glide.with(mContext)
                .load(mData.get(0).getItems().get(position).getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mData.get(0).getItems().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, price;
        Button addBtn;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            image = itemView.findViewById(R.id.imageview);
            name = itemView.findViewById(R.id.name_textview);
            price = itemView.findViewById(R.id.price_textview);
            addBtn = itemView.findViewById(R.id.add_cart_btn);
        }
    }
}
