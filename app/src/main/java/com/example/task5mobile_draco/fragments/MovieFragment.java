package com.example.task5mobile_draco.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task5mobile_draco.DetailMovieActivity;
import com.example.task5mobile_draco.OnItemClickListener;
import com.example.task5mobile_draco.R;
import com.example.task5mobile_draco.moviedata.MovieDb;
import com.example.task5mobile_draco.moviedata.MovieModel;
import com.example.task5mobile_draco.moviedata.MovieRecyclerAdapter;

public class MovieFragment extends Fragment implements OnItemClickListener<MovieModel> {
    private RecyclerView recyclerView;
    private MovieRecyclerAdapter adapter;
    private MovieDb databases;

    public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = v.findViewById(R.id.rv_movies);
        databases = new MovieDb(getActivity());
        adapter = new MovieRecyclerAdapter();
        adapter.setClickListener(this);
        adapter.setMovies(databases.getMovies());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onClick(MovieModel movieModel) {
        Intent detailActivity = new Intent(getActivity(), DetailMovieActivity.class);
        if(movieModel!=null){
            detailActivity.putExtra("MOVIE_DETAIL", movieModel);
            startActivity(detailActivity);
        }
    }
}