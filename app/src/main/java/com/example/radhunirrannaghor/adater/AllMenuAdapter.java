package com.example.radhunirrannaghor.adater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.radhunirrannaghor.FoodDetails;
import com.example.radhunirrannaghor.R;
import com.example.radhunirrannaghor.model.AllMenu;

import java.util.List;

public class AllMenuAdapter  extends RecyclerView.Adapter<AllMenuAdapter.AllMenuViewHolder> {

    Context context;
    List<AllMenu> allMenuList;

    public AllMenuAdapter(Context context, List<AllMenu> allmenuList) {
        this.context = context;
        this.allMenuList = allmenuList;
    }

    @NonNull
    @Override
    public AllMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false);

        return new AllMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllMenuViewHolder holder, final int position) {

        holder.allMenuName.setText(allMenuList.get(position).getName());
        Glide.with(context).load(allMenuList.get(position).getImageUrl()).into(holder.allMenuImage);
        holder.allMenuRating.setText(allMenuList.get(position).getRating());
        holder.allMenuTime.setText(allMenuList.get(position).getDeliveryTime());
        holder.allMenuCharges.setText(allMenuList.get(position).getDeliveryCharges());
        holder.allMenuPrice.setText(allMenuList.get(position).getPrice()+"Tk");
        holder.allMenuNote.setText(allMenuList.get(position).getNote());




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, FoodDetails.class);
                i.putExtra("name", allMenuList.get(position).getName());
                i.putExtra("price", allMenuList.get(position).getPrice());
                i.putExtra("rating", allMenuList.get(position).getRating());
                i.putExtra("image", allMenuList.get(position).getImageUrl());

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return allMenuList.size();
    }

    public static class AllMenuViewHolder extends RecyclerView.ViewHolder{

        TextView allMenuName, allMenuNote, allMenuRating, allMenuTime, allMenuCharges, allMenuPrice;
        ImageView allMenuImage;

        public AllMenuViewHolder(@NonNull View itemView) {
            super(itemView);

            allMenuName = itemView.findViewById(R.id.all_menu_name);
            allMenuNote = itemView.findViewById(R.id.all_menu_note);
            allMenuCharges = itemView.findViewById(R.id.all_menu_delivery_charge);
            allMenuRating = itemView.findViewById(R.id.all_menu_rating);
            allMenuTime = itemView.findViewById(R.id.all_menu_deliverytime);
            allMenuPrice = itemView.findViewById(R.id.all_menu_price);
            allMenuImage = itemView.findViewById(R.id.all_menu_image);
        }
    }
}
