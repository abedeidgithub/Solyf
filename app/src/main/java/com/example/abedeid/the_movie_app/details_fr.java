package com.example.abedeid.the_movie_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class details_fr extends Fragment {
    TextView title,Re,run,Vote;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details_fr, container, false);

        title = (TextView) view.findViewById(R.id.Title);
        title.setText(data_pass.getTitle());

        img=(ImageView) view.findViewById(R.id.image);
        Re= (TextView) view.findViewById(R.id.ReleasedTime);
        Re.setText(data_pass.getTime());

        run= (TextView) view.findViewById(R.id.Time);
        run.setText(data_pass.getDate());

         Vote= (TextView) view.findViewById(R.id.VoteAverage);
        Re.setText(data_pass.getVote());

        Picasso.with(getContext()).load(data_pass.getImg()).into(img);

        return view;
    }


}
