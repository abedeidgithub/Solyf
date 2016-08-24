package com.example.abedeid.the_movie_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public class Recyle_view_Adapter extends RecyclerView.Adapter<Recyle_view_Adapter.MyHolder> {
    String poster;
    List<Movie> movieList;
    Context context;
    private final static String API_KEY = "78bf6a2ef253cfbbb8e3067ab8956a4b";

    public Recyle_view_Adapter(Context context, List<Movie> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, null);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
       // videos
        poster = "http://image.tmdb.org/t/p/w320/" + movieList.get(position).getPosterPath();
        Picasso.with(context).load(poster).into(holder.imageView);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new activity
                Intent i = new Intent(context, details.class);
                Integer id = movieList.get(position).getId();
                data_pass d=new data_pass(id);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        CardView card;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.movie_photo);
            card = (CardView) itemView.findViewById(R.id.view);
        }
    }
}

