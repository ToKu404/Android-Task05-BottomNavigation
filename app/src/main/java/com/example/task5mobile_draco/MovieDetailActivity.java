package com.example.task5mobile_draco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.task5mobile_draco.moviedata.MovieModel;

public class MovieDetailActivity extends AppCompatActivity {
    private ImageView poster;
    private TextView title, genres, limitold, duration, sinopsis;
    private RatingBar rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        poster = (ImageView)findViewById(R.id.iv_mv_poster);
        title = (TextView)findViewById(R.id.tv_mv_titile);
        genres = (TextView)findViewById(R.id.tv_mv_genre);
        limitold = (TextView)findViewById(R.id.tv_mv_limit_old);
        duration = (TextView)findViewById(R.id.tv_mv_duration);
        sinopsis = findViewById(R.id.tv_mv_sinopsis);
        rating = findViewById(R.id.rb_mv);

        // Change Color Of Action Bar
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#191826"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MovieModel movieModel = getIntent().getParcelableExtra("MOVIE_DETAIL");
        poster.setImageResource(movieModel.getPoster());
        title.setText(movieModel.getTitle());
        genres.setText(movieModel.getGenres());
        limitold.setText(movieModel.getLimitold());
        duration.setText(movieModel.getDuration());
        rating.setRating(Float.parseFloat(movieModel.getRating()));
        sinopsis.setText(movieModel.getSinopsis());
        getSupportActionBar().setTitle(movieModel.getTitle());
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}