package com.example.abedeid.the_movie_app;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Abed Eid on 19/08/2016.
 */
public class Recyle_view_Adapter extends RecyclerView.Adapter<Recyle_view_Adapter.MyHolder> {

    List<Movie> movieList;
    Context context;

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

        String poster="http://image.tmdb.org/t/p/w500/"+movieList.get(position).getPosterPath();
        Picasso.with(context).load(poster).into(holder.imageView);
    holder.card.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, movieList.get(position).getOriginalTitle(), Toast.LENGTH_SHORT).show();
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
