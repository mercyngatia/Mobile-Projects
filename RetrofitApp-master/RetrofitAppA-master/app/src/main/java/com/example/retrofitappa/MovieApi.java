package com.example.retrofitappa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    //https://run.mocky.io/     v3/c38ef967-0c43-4cbb-b4a0-1f330e2d33b7
    @GET("v3/c38ef967-0c43-4cbb-b4a0-1f330e2d33b7")
    Call<List<Movie>> getMovies();
}
