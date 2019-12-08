package com.walaa.flowersmvp.module.popular_movies;

import com.walaa.flowersmvp.data.pojo.Result;

import java.util.List;

public interface Contractor {

    interface MoviesViewInterface{
        void init();
        void showError(String msg);
        void loadDataINList(List<Result> results);
    }

    interface DataManagerInterface{
        void start();
        void loadData(CallbackInterface callback);
    }

    interface CallbackInterface{
        void onSuccess(List<Result> results);
        void onError(String msg);
    }
}
