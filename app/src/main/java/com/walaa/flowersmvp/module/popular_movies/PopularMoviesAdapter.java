package com.walaa.flowersmvp.module.popular_movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.walaa.flowersmvp.R;
import com.walaa.flowersmvp.data.pojo.Result;
import com.walaa.flowersmvp.data.utils.ApiUtils;

import java.util.List;

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder> {

    List<Result> popularMoviesList;
    Context context;

    public PopularMoviesAdapter(List<Result> popularMoviesList, Context context) {
        this.popularMoviesList = popularMoviesList;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(context).inflate(R.layout.movie_list_item, parent, false);
        return new PopularMoviesViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMoviesViewHolder holder, int position) {
        Glide
                .with(context)
                .load(ApiUtils.POSTER_BASE_URL + popularMoviesList.get(position).getPosterPath())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.movieImg);
        holder.movieTiltle.setText(popularMoviesList.get(position).getTitle());
        holder.movieData.setText(popularMoviesList.get(position).getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return popularMoviesList.size();
    }


    class PopularMoviesViewHolder extends RecyclerView.ViewHolder{

        ImageView movieImg;
        TextView movieTiltle;
        TextView movieData;

        public PopularMoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImg = itemView.findViewById(R.id.cv_iv_movie_poster);
            movieTiltle = itemView.findViewById(R.id.cv_movie_title);
            movieData = itemView.findViewById(R.id.cv_movie_release_date);
        }
    }
}
