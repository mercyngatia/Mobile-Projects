package com.example.retrofitppp;

import com.google.gson.annotations.SerializedName;

public class PostModel {

    String tittle;

    @SerializedName("data")
    String bodyPost;

    json json;

    public PostModel(String tittle, String bodyPost) {
        this.tittle = tittle;
        this.bodyPost = bodyPost;
    }

    public String getTittle() {
        return tittle;
    }

    public String getBodyPost() {
        return bodyPost;
    }

    public json getJson() {
        return json;
    }
}
