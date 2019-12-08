package com.walaa.flowersmvp.module.popular_movies;


import android.util.Log;

import com.walaa.flowersmvp.data.pojo.MoviesResponse;
import com.walaa.flowersmvp.data.utils.ApiUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DataMangerPopularMovies implements Contractor.DataManagerInterface {

    private CompositeDisposable compositeDisposable;

    @Override
    public void start() {
        compositeDisposable = new CompositeDisposable();


    }

    @Override
    public void loadData(Contractor.CallbackInterface callback) {
        //if (NetworkUtils.isNetworkConnected())
        compositeDisposable.add(ApiUtils.apiService.getPopularMovies(ApiUtils.API_KEY, "en-US", 2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<MoviesResponse>() {

                            @Override
                            public void accept(MoviesResponse moviesResponse) throws Exception {
                                Log.e("!!", moviesResponse.getResults().toString());
                                callback.onSuccess(moviesResponse.getResults());
                            }
                        }, new Consumer<Throwable>() {

                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                callback.onError(throwable.getMessage());
                            }
                        }
                ));
    }
}
