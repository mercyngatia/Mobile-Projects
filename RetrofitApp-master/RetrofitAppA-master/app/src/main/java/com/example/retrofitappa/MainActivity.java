package com.example.retrofitappa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.PUT;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        movieList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApi movieApi = retrofit.create(MovieApi.class);

        Call<List<Movie>>call = movieApi.getMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.code() != 200){
                    //Handle the error and display it
                    return;
                }

                List<Movie> movies = response.body();

                for (Movie movie : movies){

                    movieList.add(movie);

                    // String responseTest = "";
                    //responseTest += movie.getId();
                    //Log.v("Tag" , "" +responseTest);
                    //  Display  in different list
                    //int k = movie.getId();
                    // String name = movie.getName();
                    //String img = movie.getImage();
                }
                PutDataIntoRecyclerView(movieList);
                //Log.v("log", String.valueOf(movieList.size()));
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }

    private void PutDataIntoRecyclerView(List<Movie> movieList) {
        Adaptery adaptery = new Adaptery(this, movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);

    }
}
