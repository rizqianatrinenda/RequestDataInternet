package com.example.rizqi.requestdatainternet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rizqi on 04/08/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> movies;
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate((R.layout.content_main), parent, false);


        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MovieViewHolder holder, int position) {

        Movie movie = movies.get(position);
        holder.id.setText(movie.getId());
        holder.title.setText(movie.getTitle());
        holder.desc.setText(movie.getDescription());



    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView id, desc, title;

        public MovieViewHolder(View view) {
            super(view);
            id = (TextView) view.findViewById(R.id.textid);
            desc =  (TextView) view.findViewById(R.id.textdesc);
            title = (TextView) view.findViewById(R.id.texttitle);
        }
    }
    public MovieAdapter(ArrayList<Movie> movieArrayList){
        this.movies = movieArrayList;
    }
}
