package com.example.radhunirrannaghor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodData {
    @SerializedName("popular")
    @Expose
    private List<Popular> popular=null;

    @SerializedName("recommended")
    @Expose
    private List<Recommanded> recommended=null;

    @SerializedName("allmenu")
    @Expose
    private List<AllMenu> allmenu=null;

    public List<Popular> getPopular() {
        return popular;
    }

    public void setPopular(List<Popular> popular) {
        this.popular = popular;
    }

    public List<Recommanded> getRecommanded() {
        return recommended;
    }

    public void setRecommanded(List<Recommanded> recommanded) {
        this.recommended = recommanded;
    }

    public List<AllMenu> getAllMenu() {
        return allmenu;
    }

    public void setAllMenu(List<AllMenu> allmenu) {
        this.allmenu = allmenu;
    }
}
