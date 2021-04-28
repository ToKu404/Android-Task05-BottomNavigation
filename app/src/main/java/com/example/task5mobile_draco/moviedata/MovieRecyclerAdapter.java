package com.example.task5mobile_draco.moviedata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task5mobile_draco.OnItemClickListener;
import com.example.task5mobile_draco.R;

import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.GridViewHolder>{
    private List<MovieModel> movies;
    private OnItemClickListener<MovieModel> clickListener;

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }

    public void setClickListener(OnItemClickListener<MovieModel> clickListener) {
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_recycler_item, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        holder.onBind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        MovieModel movieModel;
        ImageView ivPoster;
        TextView tvTitle, tvLength, tvLimitOld, tvGenre;
        RatingBar ratingBar;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPoster = itemView.findViewById(R.id.iv_movie_poster);
            tvTitle = itemView.findViewById(R.id.tv_movie_title);
            tvGenre = itemView.findViewById(R.id.tv_movie_genre);
            tvLength = itemView.findViewById(R.id.tv_movie_length);
            tvLimitOld = itemView.findViewById(R.id.tv_movie_limit_old);
            ratingBar = itemView.findViewById(R.id.rating_movie);
        }
        public void onBind(MovieModel movie) {
            this.movieModel = movie;
            ivPoster.setImageResource(movie.getPoster());
            tvTitle.setText(movie.getTitle());
            tvGenre.setText(movie.getGenres());
            tvLength.setText(movie.getDuration());
            tvLimitOld.setText(movie.getLimitold());
            ratingBar.setRating(Float.parseFloat(movie.getRating()));
        }
        @Override
        public void onClick(View v) {
            clickListener.onClick(movieModel);
        }
    }
}
