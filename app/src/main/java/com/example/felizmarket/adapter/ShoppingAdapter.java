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
import com.example.felizmarket.db.CartItem;

import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.MyViewHolder>
{
    private Context mContext;
    private List<CartItem> items;

    public ShoppingAdapter(Context mContext, List<CartItem> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.shopping_cart, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.name.setText(items.get(position).getProductName());
        holder.price.setText(items.get(position).getPrice());

        Glide.with(mContext).load(items.get(position).getImg()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name , price , totalprice ;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_textview_shopping);
            price = itemView.findViewById(R.id.price_textview_shopping);
            totalprice = itemView.findViewById(R.id.price_total_shopping);
            img = itemView.findViewById(R.id.imageview_shopping);
        }
    }
}
