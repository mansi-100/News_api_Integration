package com.example.news_api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class recylerview_adapter extends RecyclerView.Adapter<viewHolder> {

Context context;
List<news> list;


    public recylerview_adapter(Context context, List<news> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_news_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        news item=list.get(position);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.urlToImage.setText(item.getImageUrl());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
