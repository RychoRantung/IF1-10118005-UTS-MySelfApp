package com.rychorantung.if1_10118005_utsproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class AdapterGalleryActivity extends RecyclerView.Adapter<AdapterGalleryActivity.DailyViewHolder> {

    private final Context context;
    private final int[] imgGallery;

    public AdapterGalleryActivity(Context context, int[] imgGallery) {
        this.context = context;
        this.imgGallery = imgGallery;
    }


    @NonNull
    @NotNull
    @Override
    public AdapterGalleryActivity.DailyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery, parent, false);
        return new AdapterGalleryActivity.DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DailyViewHolder holder, int position) {
        holder.imageView.setImageResource(imgGallery[position]);
    }


    @Override
    public int getItemCount() {
        return imgGallery.length;
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;

        public DailyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_gallery);
        }
    }
}
