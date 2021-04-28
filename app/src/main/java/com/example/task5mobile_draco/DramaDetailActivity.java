package com.example.task5mobile_draco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.task5mobile_draco.dramadata.DramaModel;

public class DramaDetailActivity extends AppCompatActivity {
    private ImageView ivPoster, ivBanner;
    private TextView tvTitle;
    private TextView tvGenre;
    private TextView tvSinopsis;
    private TextView tvEps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drama_detail);
        ivBanner = (ImageView)findViewById(R.id.iv_dr_banner);
        ivPoster = (ImageView)findViewById(R.id.iv_dr_poster);
        tvTitle = (TextView)findViewById(R.id.tv_dr_title);
        tvGenre = (TextView)findViewById(R.id.tv_dr_genre);
        tvSinopsis = (TextView)findViewById(R.id.tv_dr_sinopsis);
        tvEps = (TextView)findViewById(R.id.tv_dr_eps);
        // Change Color Of Action Bar
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#191826"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
        DramaModel dramaModel = getIntent().getParcelableExtra("DRAMA_DETAIL");
        ivPoster.setImageResource(dramaModel.getPoster());
        ivBanner.setImageResource(dramaModel.getPoster());
        tvTitle.setText(dramaModel.getTitle());
        tvGenre.setText(dramaModel.getGenre());
        tvEps.setText(dramaModel.getEps());
        tvSinopsis.setText(dramaModel.getSinopsis());
        getSupportActionBar().setTitle(dramaModel.getTitle());
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