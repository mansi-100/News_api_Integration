package com.example.news_api;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends RecyclerView.ViewHolder {
TextView title,description,urlToImage;

    public viewHolder(@NonNull View itemView) {
        super(itemView);
        Context context=itemView.getContext();
        title=itemView.findViewById(R.id.title);
        description=itemView.findViewById(R.id.description);
        urlToImage=itemView.findViewById(R.id.urlToImage);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=getAdapterPosition();
                if(pos==0){
                    Toast.makeText(context, "Clicked item0", Toast.LENGTH_SHORT).show();
                }
                else if(pos==1){
                    Toast.makeText(context, "Clicked item1", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "extra", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
