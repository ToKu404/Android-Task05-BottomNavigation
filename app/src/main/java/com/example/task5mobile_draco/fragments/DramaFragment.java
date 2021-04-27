package com.example.task5mobile_draco.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task5mobile_draco.DramaDetailActivity;
import com.example.task5mobile_draco.OnItemClickListener;
import com.example.task5mobile_draco.R;
import com.example.task5mobile_draco.dramadata.DramaDb;
import com.example.task5mobile_draco.dramadata.DramaModel;
import com.example.task5mobile_draco.dramadata.DramaRecyclerAdaptor;

public class DramaFragment extends Fragment implements OnItemClickListener<DramaModel> {
    private RecyclerView recyclerView;
    private DramaRecyclerAdaptor adapter;
    private DramaDb databases;
    public static DramaFragment newInstance() {

        DramaFragment fragment = new DramaFragment();
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
        View v = inflater.inflate(R.layout.fragment_drama, container, false);
        recyclerView = v.findViewById(R.id.rv_drama);
        databases = new DramaDb(getActivity());
        adapter = new DramaRecyclerAdaptor();
        adapter.setClickListener(this);
        adapter.setDrama(databases.getListDrama());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return v;
    }
    @Override
    public void onClick(DramaModel dramaModel) {
        Intent detailActivity = new Intent(getActivity(), DramaDetailActivity.class);
        if(dramaModel!=null){
            detailActivity.putExtra("DRAMA_DETAIL", dramaModel);
            startActivity(detailActivity);
        }
    }
}