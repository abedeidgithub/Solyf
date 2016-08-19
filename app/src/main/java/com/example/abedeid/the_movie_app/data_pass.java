package com.example.abedeid.the_movie_app;

/**
 * Created by Abed Eid on 20/08/2016.
 */
public class data_pass {

    private static   String title;
    private static String img;
    private static String time;
    private static String date;
    private static String vote;

    public data_pass(String title, String imageView , String time ,String date ,String vote  ) {
        this.title = title;
        this.img=imageView;
        this.time=time;
        this.date=date;
        this.vote=vote;


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
