package com.walaa.flowersmvp.data.remote;

import com.walaa.flowersmvp.data.pojo.MoviesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesService {

    @GET("movie/popular")
    Single<MoviesResponse> getPopularMovies(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page
    );
}
