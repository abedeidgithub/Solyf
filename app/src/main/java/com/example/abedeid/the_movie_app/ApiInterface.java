package com.example.abedeid.the_movie_app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public interface ApiInterface {
//    http://api.themoviedb.org/3  /movie/top_rated   ?api_key=78bf6a2ef253cfbbb8e3067ab8956a4b
    @GET("movie/top_rated")
    Call<Result> get_Top_rated(@Query("api_key") String API_KEY);
 @GET("movie/popular")
    Call<Result> get_popular(@Query("api_key") String API_KEY);

    @GET("movie/{id}")
    Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);


    @GET("movie/{id}/{type}")
    Call<trailerReviews> getMovie(@Path("id") int id, @Path("type") String Type , @Query("api_key") String apiKey);
    @GET("movie/{id}/{type}")
    Call<ResultReviews> getMovie1(@Path("id") int id, @Path("type") String Type , @Query("api_key") String apiKey);


}
