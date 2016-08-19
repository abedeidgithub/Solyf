package com.example.abedeid.the_movie_app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public class ApiClient {
    final static String Basic_URL = "http://api.themoviedb.org/3/";
    static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Basic_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
