package com.walaa.flowersmvp.data.utils;

import com.walaa.flowersmvp.data.remote.MoviesRetrofit;
import com.walaa.flowersmvp.data.remote.MoviesService;

public class ApiUtils {

    public static final String BASE_URL = "https://developers.themoviedb.org/3/movies/";
    public static final String API_KEY = "77a55d760786b1d3455d3b44ae00f0df";
    public static final String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342";
    public static final MoviesService apiService = MoviesRetrofit.getRetrofit().create(MoviesService.class);
}
