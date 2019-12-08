package com.walaa.flowersmvp.module.popular_movies;

import com.walaa.flowersmvp.data.pojo.Result;

import java.util.List;

public class PresenterPopularMovies implements Contractor.CallbackInterface {

    private Contractor.MoviesViewInterface mView;
    private DataMangerPopularMovies dataMangerPopularMovies;


    public PresenterPopularMovies(DataMangerPopularMovies dataMangerPopularMovies) {
        this.dataMangerPopularMovies = dataMangerPopularMovies;
    }

    @Override
    public void strat() {
        mView.init();

    }

    @Override
    public void onSuccess(List<Result> results) {

        mView.loadDataINList(results);

    }


    @Override
    public void onError(String msg) {
        mView.showError(msg);
    }


}
