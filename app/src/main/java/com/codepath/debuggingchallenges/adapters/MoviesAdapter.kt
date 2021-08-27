package com.codepath.debuggingchallenges.adapters

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.codepath.debuggingchallenges.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.codepath.debuggingchallenges.models.Movie

class MoviesAdapter(private val movies: List<Movie>?) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    inner class ViewHolder(  // only needed because we need to set the background color
            var view: View) : RecyclerView.ViewHolder(view) {
        // Lookup view for data population
        var tvName: TextView = itemView.findViewById(R.id.tvTitle)
        var tvRating: TextView = itemView.findViewById(R.id.tvRating)
        var ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val movieView = inflater.inflate(R.layout.item_movie, parent, false)

        // Return a new holder instance
        return ViewHolder(movieView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        if (movies != null) {
            val movie = movies[position]


            // Populate the data into the template view using the data object
            viewHolder.tvName.text = movie.title
            val resources = viewHolder.tvName.resources
            val movieRating = movie.rating
            if (movieRating > 6) {
                viewHolder.view.setBackgroundColor(Color.GREEN)
            }
            val ratingText = String.format(resources.getString(R.string.rating), movieRating)
            viewHolder.tvRating.text = ratingText
            Glide.with(viewHolder.ivPoster.context).load(movie.posterUrl).into(
                    viewHolder.ivPoster)
        }
    }
}