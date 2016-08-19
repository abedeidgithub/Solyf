package com.example.abedeid.the_movie_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment {
    RecyclerView recyclerView;
    private final static String API_KEY = "78bf6a2ef253cfbbb8e3067ab8956a4b";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.view2);

        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<Result> top_rated = api.get_Top_rated(API_KEY);
        top_rated.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                List<Movie> results = response.body().getResults();
                Recyle_view_Adapter adapter = new Recyle_view_Adapter(getContext(), results);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        return view;
    }

}