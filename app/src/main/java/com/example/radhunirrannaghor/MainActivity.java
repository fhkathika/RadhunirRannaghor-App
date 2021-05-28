package com.example.radhunirrannaghor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.radhunirrannaghor.R;
import com.example.radhunirrannaghor.adater.AllMenuAdapter;
import com.example.radhunirrannaghor.adater.PopularAdapter;
import com.example.radhunirrannaghor.adater.RecommandedAdapter;
import com.example.radhunirrannaghor.model.AllMenu;
import com.example.radhunirrannaghor.model.FoodData;
import com.example.radhunirrannaghor.model.Popular;
import com.example.radhunirrannaghor.model.Recommanded;
import com.example.radhunirrannaghor.retrofit.ApiInterface;
import com.example.radhunirrannaghor.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
ApiInterface apiInterface;
RecyclerView allMenuRecyclerView,popularRecyclerView,recommendedRecyclerView;

PopularAdapter popularAdapter;
AllMenuAdapter allMenuAdapter;
RecommandedAdapter recommendedAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface= RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<List<FoodData>> call=apiInterface.getAllData();
        call.enqueue(new Callback<List<FoodData>>() {
            @Override
            public void onResponse(Call<List<FoodData>> call, Response<List<FoodData>> response) {
                List<FoodData> foodDataList=response.body();
                getPopularData(foodDataList.get(0).getPopular());
                getRecommendedData(foodDataList.get(0).getRecommanded());
                getAllMenu(foodDataList.get(0).getAllMenu());
            }




            @Override
            public void onFailure(Call<List<FoodData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Service is not responding", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void  getPopularData(List<Popular> popularList){

        popularRecyclerView = findViewById(R.id.popular_recycler);
        popularAdapter = new PopularAdapter(this, popularList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);

    }

    private void  getRecommendedData(List<Recommanded> recommendedList){

        recommendedRecyclerView = findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommandedAdapter(this, recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }

    private void  getAllMenu(List<AllMenu> allmenuList){

        allMenuRecyclerView = findViewById(R.id.all_menu_recycler);
        allMenuAdapter = new AllMenuAdapter(this, allmenuList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
        allMenuAdapter.notifyDataSetChanged();

    }
}