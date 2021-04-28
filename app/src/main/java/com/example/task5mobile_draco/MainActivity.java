package com.example.task5mobile_draco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.task5mobile_draco.fragments.DramaFragment;
import com.example.task5mobile_draco.fragments.HistoryFragment;
import com.example.task5mobile_draco.fragments.MovieFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    // BottomNavigationVie
    private BottomNavigationView bottomNavigationView;
    //Map dari Fragment-fragment
    private Map<Integer, Fragment> fragmentMap;

    // Ketika Activiy Dibuat
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Kita instance bottom nav dengan memiih id bottom nav
        bottomNavigationView = findViewById(R.id.bottom_nav);
        //Instance HashMap
        fragmentMap = new HashMap<>();
        // Change Color Of Action Bar
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#191826"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    //Ketika Activity Dimulai
    @Override
    protected void onStart() {
        super.onStart();
        // Menambahkan fragment2 kedalam hashmap yang keynya adalah id fragmane, dan valuenya fragment
        fragmentMap.put(R.id.menu_item_drama, DramaFragment.newInstance());
        fragmentMap.put(R.id.menu_item_movie, MovieFragment.newInstance());
        fragmentMap.put(R.id.menu_item_history, HistoryFragment.newInstance());

        //Bottom Navigation setting, dan memilih fragment awal
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_item_drama);
    }

    //Method Menentukan Navigasi Bottom item yang diPilih, denga parameter berupa item dari bottom nav
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Membuat fragment dari fragment map, berdasarkan item yang dipilih
        Fragment fragment = fragmentMap.get(item.getItemId());
        assert fragment != null;
        // switch case item yang dipilih, untuk menentukan title dari action bar
        switch (item.getItemId()){
            case R.id.menu_item_drama:
                setActionBarTitle("Drama");
                break;
            case R.id.menu_item_movie:
                setActionBarTitle("Movie");
                break;
            case R.id.menu_item_history:
                setActionBarTitle("History");
                break;
        }
        //Mengganti frame layout dengan fragment yang dipilih
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
        return  true;
    }
    //Method yang dipanggil untuk mengubah titel action bar
    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}