package com.example.abedeid.the_movie_app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public interface ApiInterface {
//    http://api.themoviedb.org/3  /movie/top_rated   ?api_key=78bf6a2ef253cfbbb8e3067ab8956a4b
    @GET("movie/top_rated")
    Call<Result> get_Top_rated(@Query("api_key") String API_KEY);
}
