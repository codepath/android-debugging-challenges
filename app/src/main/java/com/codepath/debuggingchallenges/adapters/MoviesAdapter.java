package com.codepath.debuggingchallenges.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.debuggingchallenges.R;
import com.codepath.debuggingchallenges.models.Movie;

import java.util.List;

public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(getContext())
                    .inflate(R.layout.item_movie, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvRating = (TextView) convertView.findViewById(R.id.tvRating);
        ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);


        // Populate the data into the template view using the data object
        tvName.setText(movie.getTitle());

        Resources resources = getContext().getResources();
        double movieRating = movie.getRating();

        if (movieRating > 6) {
            convertView.setBackgroundColor(Color.GREEN);
        }

        String ratingText = String.format(resources.getString(R.string.rating), movieRating);
        tvRating.setText(ratingText);

        Glide.with(getContext()).load(movie.getPosterUrl()).into(ivPoster);

        // Return the completed view to render on screen
        return convertView;
    }
}
