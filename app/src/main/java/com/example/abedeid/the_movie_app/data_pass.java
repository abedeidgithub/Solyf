package com.example.abedeid.the_movie_app;

/**
 * Created by Abed Eid on 20/08/2016.
 */
public class data_pass {
    private static int id;
    private static String title;
    private static String img;
    private static String time;
    private static String date;
    private static String vote;
    private static String overview;

    public data_pass(int id) {
    this.id=id;
    }

    public data_pass(String title, String imageView, String time, String date, String vote, String overview) {
        this.title = title;
        this.img = imageView;
        this.time = time;
        this.date = date;
        this.vote = vote;
        this.overview = overview;

    }

    public static int getId() {
        return id;
    }

    public static String getOverview() {
        return overview;
    }

    public static String getTitle() {
        return title;
    }

    public static String getImg() {
        return img;
    }

    public static String getTime() {
        return time;
    }

    public static String getDate() {
        return date;
    }

    public static String getVote() {
        return vote;
    }
}
