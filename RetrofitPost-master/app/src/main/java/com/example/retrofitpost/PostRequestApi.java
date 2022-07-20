package com.example.retrofitpost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostRequestApi {
    // https://httpbin.org/post

    @POST("post")
    Call<PostModel>PostDataIntoServer(@Body PostModel postModel);
}
