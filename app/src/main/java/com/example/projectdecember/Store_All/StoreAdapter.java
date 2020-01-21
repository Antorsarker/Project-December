package com.example.projectdecember.Store_All;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.projectdecember.R;


import java.util.ArrayList;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<Movie> movieList;


    public StoreAdapter(Context context, ArrayList<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_item_row,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Movie movie=movieList.get(position);

        holder.name.setText(movie.title);
        holder.price.setText(movie.price);

        Glide.with(context)
                .load(movie.image)
                .into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
         return movieList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.title);
            price = view.findViewById(R.id.price);
            thumbnail = view.findViewById(R.id.thumbnail);
        }
    }

}