package com.rychorantung.if1_10118005_utsproject.ui.daily;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rychorantung.if1_10118005_utsproject.R;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterFriendActivity extends RecyclerView.Adapter<AdapterFriendActivity.DailyViewHolder> {

    private final Context context;
    private final String[] friendAct;
    private final int[] imgFriend;

    public AdapterFriendActivity(Context context, String[] friendAct, int[] imgFriend) {
        this.context = context;
        this.friendAct = friendAct;
        this.imgFriend = imgFriend;
    }

    @NonNull
    @Override
    public AdapterFriendActivity.DailyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_friendlist, parent, false);
        return new AdapterFriendActivity.DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterFriendActivity.DailyViewHolder holder, int position) {
        holder.imageView.setImageResource(imgFriend[position]);
        holder.textView.setText(friendAct[position]);
    }

    @Override
    public int getItemCount() {
        return friendAct.length;
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        TextView textView;

        public DailyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_friend);
            textView = itemView.findViewById(R.id.txt_friend);
        }
    }
}

