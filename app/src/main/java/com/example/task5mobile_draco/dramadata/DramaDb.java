package com.example.task5mobile_draco.dramadata;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.task5mobile_draco.R;

import java.util.ArrayList;
import java.util.List;

public class DramaDb {
    private Context context;

    public DramaDb(Context context) {
        this.context = context;
    }
    public List<DramaModel> getListDrama() {
        List<DramaModel> listDrama = new ArrayList<>();
        TypedArray posters = context.getResources().obtainTypedArray(R.array.dr_poster);
        String[] titles = context.getResources().getStringArray(R.array.dr_titles);
        String[] genres = context.getResources().getStringArray(R.array.dr_genres);
        String[] eps = context.getResources().getStringArray(R.array.dr_eps);
        String[] sinopsis = context.getResources().getStringArray(R.array.dr_sinopsis);
        for (int i = 0; i < titles.length; i++) {
            DramaModel drama = new DramaModel();
            drama.setPoster(posters.getResourceId(i, -1));
            drama.setTitle(titles[i]);
            drama.setGenre(genres[i]);
            drama.setSinopsis(sinopsis[i]);
            drama.setEps(eps[i]);
            listDrama.add(drama);
        }
        return listDrama;
    }
}
