package com.example.felizmarket.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.felizmarket.R;
import com.example.felizmarket.model.ProductsResponse;

import java.util.ArrayList;

public class AdapterItemGrid  extends RecyclerView.Adapter<AdapterItemGrid.MyViewHolder> {

    private Context mContext;
    private ArrayList<ProductsResponse> mData;

    public AdapterItemGrid(Context mContext, ArrayList<ProductsResponse> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cart_item_grid_layout, parent, false);

        return new MyViewHolder(view);
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


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageview2);
            name = itemView.findViewById(R.id.name_textview2);
            price = itemView.findViewById(R.id.price_textview2);
        }
    }
}
