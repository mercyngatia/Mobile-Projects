package com.example.retrofitjsonnested;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {
//https://run.mocky.io/     v3/6360ab61-dfcf-4af1-b7b2-ee52d9081d7a
    @GET("v3/6360ab61-dfcf-4af1-b7b2-ee52d9081d7a")
    Call<JSONResponse> getMovies();
}
