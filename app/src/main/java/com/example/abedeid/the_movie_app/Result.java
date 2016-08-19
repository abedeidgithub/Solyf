package com.example.abedeid.the_movie_app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public class Result {
    @SerializedName("results")
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
