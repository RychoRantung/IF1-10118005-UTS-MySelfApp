package com.rychorantung.if1_10118005_utsproject.ui.music;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.rychorantung.if1_10118005_utsproject.R;

import org.jetbrains.annotations.NotNull;

public class AdapterMusicActivity extends RecyclerView.Adapter<AdapterMusicActivity.DailyViewHolder> {

    private final Context context;

    public AdapterMusicActivity(Context context, String[] musicAct, int[] imgMusic) {
        this.context = context;
        this.musicAct = musicAct;
        this.imgMusic = imgMusic;
    }

    private final String[] musicAct;
    private final int[] imgMusic;





    @NonNull
    @Override
    public AdapterMusicActivity.DailyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_music, parent, false);
        return new AdapterMusicActivity.DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterMusicActivity.DailyViewHolder holder, int position) {
        holder.imageView.setImageResource(imgMusic[position]);
        holder.textView.setText(musicAct[position]);
    }

    @Override
    public int getItemCount() {
        return musicAct.length;
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public DailyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_music);
            textView = itemView.findViewById(R.id.txt_music);

        }
    }
}

