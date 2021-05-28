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
import com.example.radhunirrannaghor.model.Recommanded;

import java.util.List;

public class RecommandedAdapter extends RecyclerView.Adapter<RecommandedAdapter.RecomanddedViewHoldr> {
    Context context;
    List<Recommanded> recommandedList;

    public RecommandedAdapter(Context context, List<Recommanded> recommandedList) {
        this.context = context;
        this.recommandedList = recommandedList;
    }

    @NonNull
    @Override
    public RecomanddedViewHoldr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommended_recycler_items, parent, false);

        return new RecomanddedViewHoldr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecomanddedViewHoldr holder, int position) {
        holder.recommendedName.setText(recommandedList.get(position).getName());
        holder.recommendedRating.setText(recommandedList.get(position).getRating());
        holder.recommendedCharges.setText(recommandedList.get(position).getDeliveryCharges());
        holder.recommendedDeliveryTime.setText(recommandedList.get(position).getDeliveryTime());
        holder.recommendedPrice.setText(recommandedList.get(position).getPrice());

        Glide.with(context).load(recommandedList.get(position).getImageUrl()).into(holder.recommendedImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, FoodDetails.class);
                i.putExtra("name", recommandedList.get(position).getName());
                i.putExtra("price", recommandedList.get(position).getPrice());
                i.putExtra("rating", recommandedList.get(position).getRating());
                i.putExtra("image", recommandedList.get(position).getImageUrl());

                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return recommandedList.size();
    }

    public static class RecomanddedViewHoldr extends RecyclerView.ViewHolder {
        ImageView recommendedImage;
        TextView recommendedName, recommendedRating, recommendedDeliveryTime, recommendedCharges, recommendedPrice;

        public RecomanddedViewHoldr(@NonNull View itemView) {
            super(itemView);
            recommendedImage = itemView.findViewById(R.id.recommended_image);
            recommendedName = itemView.findViewById(R.id.recommended_name);
            recommendedRating = itemView.findViewById(R.id.recommended_rating);
            recommendedDeliveryTime = itemView.findViewById(R.id.recommended_delivery_time);
            recommendedCharges = itemView.findViewById(R.id.delivery_type);
            recommendedPrice = itemView.findViewById(R.id.recommended_price);
        }
    }
}
