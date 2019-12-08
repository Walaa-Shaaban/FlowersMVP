package com.walaa.flowersmvp.module;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.walaa.flowersmvp.R;
import com.walaa.flowersmvp.data.pojo.Result;
import com.walaa.flowersmvp.module.popular_movies.Contractor;
import com.walaa.flowersmvp.module.popular_movies.DataMangerPopularMovies;
import com.walaa.flowersmvp.module.popular_movies.PopularMoviesAdapter;
import com.walaa.flowersmvp.module.popular_movies.PresenterPopularMovies;

import java.util.List;

public class PopularMoviesActivity extends AppCompatActivity implements Contractor.MoviesViewInterface {

    private PresenterPopularMovies presenterPopularMovies;
    private RecyclerView mRecMovies;
    private LinearLayoutManager mRecManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    @Override
    public void init() {

        presenterPopularMovies = new PresenterPopularMovies(new DataMangerPopularMovies());
        mRecMovies = findViewById(R.id.rc_movie);
        mRecManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadDataINList(List<Result> results) {
        mRecMovies.setAdapter(new PopularMoviesAdapter(results, this.getBaseContext()));
    }
}

