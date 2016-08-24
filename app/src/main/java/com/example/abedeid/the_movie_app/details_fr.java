package com.example.abedeid.the_movie_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abedeid.the_movie_app.M_Realm.DataBaseRealm;
import com.example.abedeid.the_movie_app.M_Realm.Realm_Helper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class details_fr extends Fragment {
    TextView title, Re, run, Vote, overview;
    ImageView img;
    Button save;
    private final static String API_KEY = "78bf6a2ef253cfbbb8e3067ab8956a4b";
    RecyclerView recyclerView, recyclerView2;
    int id;
    Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_details_fr, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.tailr);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.over);
        save = (Button) view.findViewById(R.id.favourite_Btn);
        id = data_pass.getId();
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<Movie> movieDetails = api.getMovieDetails(id, API_KEY);
        movieDetails.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {

                title = (TextView) view.findViewById(R.id.Title);
                title.setText(response.body().getOriginalTitle());

                img = (ImageView) view.findViewById(R.id.image);
                Picasso.with(getContext()).load("http://image.tmdb.org/t/p/w320" + response.body().getPosterPath()).into(img);

                Re = (TextView) view.findViewById(R.id.ReleasedTime);
                Re.setText(response.body().getReleaseDate().substring(0, 4));


                run = (TextView) view.findViewById(R.id.Time);
                run.setText(response.body().getruntime() + " min");

                Vote = (TextView) view.findViewById(R.id.VoteAverage);
                Vote.setText(response.body().getVoteAverage() + "/10");

                overview = (TextView) view.findViewById(R.id.Overview);
                overview.setText(response.body().getOverview());


            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });


        ApiInterface api_ = ApiClient.getClient().create(ApiInterface.class);
        final Call<trailerReviews> reviews = api_.getMovie(id, "videos", API_KEY);
        reviews.enqueue(new Callback<trailerReviews>() {
            @Override
            public void onResponse(Call<trailerReviews> call, Response<trailerReviews> response) {
                List<trailer> reviewsList = response.body().getResults();
                Recyle_view_Talir_adapter adapter = new Recyle_view_Talir_adapter(reviewsList, getContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<trailerReviews> call, Throwable t) {

            }
        });


        ApiInterface api_1 = ApiClient.getClient().create(ApiInterface.class);
        Call<ResultReviews> reviews1 = api_1.getMovie1(id, "reviews", API_KEY);
        reviews1.enqueue(new Callback<ResultReviews>() {
            @Override
            public void onResponse(Call<ResultReviews> call, Response<ResultReviews> response) {
                List<Reviews> results = response.body().getResults();
                Recyle_view_overview_adapter adapter = new Recyle_view_overview_adapter(results, getContext());
                recyclerView2.setAdapter(adapter);
                recyclerView2.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<ResultReviews> call, Throwable t) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RealmConfiguration configuration = new RealmConfiguration.Builder(getContext()).build();
                realm = Realm.getInstance(configuration);
                Realm_Helper helperw = new Realm_Helper(realm);
                ArrayList<Integer> select = helperw.Select();
                for (int i = 0; i < select.size(); i++) {
                    Toast.makeText(getContext(), select.get(i)+"", Toast.LENGTH_SHORT).show();
                    Log.d("abed2",select.get(i)+"\n");
                }
                Toast.makeText(getContext(), "found" + id, Toast.LENGTH_SHORT).show();
                DataBaseRealm r = new DataBaseRealm();
                r.setId(id);
                r.setName("jhb");
                Realm_Helper helper = new Realm_Helper(realm);
                helper.insert(r);
                Toast.makeText(getContext(), "done" , Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }


}
