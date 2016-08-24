package com.example.abedeid.the_movie_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.abedeid.the_movie_app.M_Realm.Realm_Helper;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment {
    RecyclerView recyclerView;
    private final static String API_KEY = "78bf6a2ef253cfbbb8e3067ab8956a4b";
    Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.view2);
        get_Movie();
        setHasOptionsMenu(true);
        return view;
    }

    private void get_Movie() {
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
    }

    private void get_Movie_popular() {
        ApiInterface api = ApiClient.getClient().create(ApiInterface.class);
        Call<Result> top_rated = api.get_popular(API_KEY);
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
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.activity_main_actions, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle item selection
        switch (item.getItemId()) {
            case R.id.popular:
                // do s.th.
                get_Movie_popular();
                Toast.makeText(getContext(), "popilar", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.top_rated:
                // do s.th.
                get_Movie();
                Toast.makeText(getContext(), "top_rated", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.favourite:
                // do s.th.
                RealmConfiguration configuration = new RealmConfiguration.Builder(getContext()).build();
                realm = Realm.getInstance(configuration);
                Realm_Helper helper = new Realm_Helper(realm);
                ArrayList<Integer> out = helper.Select();
                Log.d("abed2",out.size()+"");
                for (int i = 0; i < out.size(); i++) {
                    Toast.makeText(getContext(), out.get(i)+"", Toast.LENGTH_SHORT).show();
                    Log.d("abed2",out.get(i)+"\n");
                }
                Toast.makeText(getContext(), "favourite", Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}