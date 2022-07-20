package com.example.retrofitjsonnested;

import com.google.gson.annotations.SerializedName;

public class Movie {

    //model class
    private String id;
    private String title;
    private float rating;
    private String poster;

    //Object of class details
    //Different name from JSON, so we need to serialize it
    @SerializedName("Details")
    private MoreDetails moreDetails;
//constructor
    public Movie(String id, String title, float rating, String poster, MoreDetails moreDetails) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.poster = poster;
        this.moreDetails = moreDetails;
    }
    //Getters and Setters


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getRating() {
        return rating;
    }

    public String getPoster() {
        return poster;
    }

    public MoreDetails getMoreDetails() {
        return moreDetails;
    }
}
