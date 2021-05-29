package com.rychorantung.if1_10118005_utsproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class RecylcerViewAdapterGallery extends RecyclerView.Adapter<RecylcerViewAdapterGallery.MyViewHolder>{
   int []arr;

    public RecylcerViewAdapterGallery(int[] arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arr[position]);
        holder.textView.setText("Image No." + position);

    }

    @Override
    public int getItemCount() {
        return arr.length;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;


        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
