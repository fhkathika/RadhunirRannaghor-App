package com.example.radhunirrannaghor.retrofit;

import com.example.radhunirrannaghor.model.FoodData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
@GET("fooddata.json")
    Call<List<FoodData>> getAllData();

}
