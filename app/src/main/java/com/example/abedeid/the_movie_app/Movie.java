package com.example.abedeid.the_movie_app;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public class Movie {

    @SerializedName("id")
    private Integer id;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("runtime")
    private Integer runtime;

    @SerializedName("original_title")
    private String originalTitle;


    @SerializedName("vote_average")
    private Double voteAverage;

    public Integer getId() {
        return id;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }


    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getruntime() {
        return runtime;
    }

    public void setruntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
