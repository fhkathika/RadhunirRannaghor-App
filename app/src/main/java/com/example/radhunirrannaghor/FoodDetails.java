package com.example.radhunirrannaghor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FoodDetails extends AppCompatActivity {
    ImageView imageView,imageViewBackToHome;
    TextView itemName,itemPrice,itemRating;
    RatingBar ratingBar;

    String name,price,rating,imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        Intent intent=getIntent();

        name=intent.getStringExtra("name");
        price=intent.getStringExtra("price");
        rating=intent.getStringExtra("rating");
        imageUrl=intent.getStringExtra("image");

        imageView=findViewById(R.id.imageView5);
        imageViewBackToHome=findViewById(R.id.imageView2);
        itemName=findViewById(R.id.name);
        itemPrice=findViewById(R.id.price);
        itemRating=findViewById(R.id.rating);
        ratingBar=findViewById(R.id.ratingBar);


        Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        itemName.setText(name);
        itemPrice.setText(price);
        itemRating.setText(rating);
        ratingBar.setRating(Float.parseFloat(rating));

        imageViewBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FoodDetails.this,MainActivity.class);
                startActivity(i);
            }
        });



    }

}