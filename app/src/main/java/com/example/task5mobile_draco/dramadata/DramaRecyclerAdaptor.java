package com.example.task5mobile_draco.dramadata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task5mobile_draco.OnItemClickListener;
import com.example.task5mobile_draco.R;
import java.util.List;


public class DramaRecyclerAdaptor extends RecyclerView.Adapter<DramaRecyclerAdaptor.ViewHolder> {
    private List<DramaModel> drama;
    private OnItemClickListener<DramaModel> clickListener;

    public void setDrama(List<DramaModel> drama) {
        this.drama = drama;
    }

    public void setClickListener(OnItemClickListener<DramaModel> clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drama_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(drama.get(position));
    }

    @Override
    public int getItemCount() {
        return drama.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        DramaModel drama;
        ImageView ivPoster;
        TextView tvTitle;
        TextView tvGenre;
        TextView tvSinopsis;
        TextView tvTipe;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPoster = itemView.findViewById(R.id.iv_drama_image);
            tvTitle = itemView.findViewById(R.id.tv_drama_name);
            tvGenre = itemView.findViewById(R.id.tv_drama_genre);
            tvSinopsis = itemView.findViewById(R.id.tv_drama_sinopsis);
            tvTipe = itemView.findViewById(R.id.tv_drama_tipe);

        }

        public void onBind(DramaModel drama) {
            this.drama = drama;
            ivPoster.setImageResource(drama.getPoster());
            tvTitle.setText(drama.getTitle());
            tvGenre.setText(drama.getGenre());
            tvSinopsis.setText(drama.getSinopsis());
            tvTipe.setText(drama.getTipe());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(drama);
        }
    }
}
