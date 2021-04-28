package com.example.task5mobile_draco.moviedata;

import android.content.Context;
import android.content.res.TypedArray;


import com.example.task5mobile_draco.R;

import java.util.ArrayList;
import java.util.List;

public class MovieDb {
    private Context context;

    public MovieDb(Context context) {
        this.context = context;
    }

    public List<MovieModel> getMovies(){
        List<MovieModel> movies = new ArrayList<>();

        TypedArray posters = context.getResources().obtainTypedArray(R.array.mv_poster);
        String[] titles = context.getResources().getStringArray(R.array.mv_titles);
        String[] genres = context.getResources().getStringArray(R.array.mv_genres);
        String[] length = context.getResources().getStringArray(R.array.mv_length);
        String[] limitOld = context.getResources().getStringArray(R.array.mv_min_old);
        String[] rating = context.getResources().getStringArray(R.array.mv_rating);
        String[] sinopsis = context.getResources().getStringArray(R.array.mv_sinopsis);

        for (int i = 0; i < titles.length; i++) {
            MovieModel movie = new MovieModel();
            movie.setPoster(posters.getResourceId(i, -1));
            movie.setTitle(titles[i]);
            movie.setGenres(genres[i]);
            movie.setDuration(length[i]);
            movie.setLimitold(limitOld[i]);
            movie.setRating(rating[i]);
            movie.setSinopsis(sinopsis[i]);
            movies.add(movie);
        }
        return movies;
    }
}
