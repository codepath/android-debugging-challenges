package com.codepath.debuggingchallenges.activities

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.codepath.debuggingchallenges.adapters.MoviesAdapter
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.codepath.debuggingchallenges.R
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import org.json.JSONException
import com.codepath.debuggingchallenges.models.Movie
import okhttp3.Headers
import java.util.ArrayList

private const val TAG = "MoviesActivity"
class MoviesActivity : AppCompatActivity() {
    private var rvMovies: RecyclerView? = null
    var adapter: MoviesAdapter? = null
    //var movies: List<Movie>? = null
    private val movies = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        rvMovies = findViewById(R.id.rvMovies)

        // Create the adapter to convert the array to views
        adapter = MoviesAdapter(movies)

        rvMovies?.layoutManager = LinearLayoutManager(this)

        // Attach the adapter to a ListView
        rvMovies?.adapter = adapter
        fetchMovies()
    }

    private fun fetchMovies() {
        val url = " https://api.themoviedb.org/3/movie/now_playing?api_key=$API_KEY"
        val client = AsyncHttpClient()
        client[url, null, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, response: JSON) {
                try {
                    val moviesJson = response.jsonObject.getJSONArray("results")
                    //movies = Movie.fromJSONArray(moviesJson)
                    movies.addAll(Movie.fromJSONArray(moviesJson))
                    adapter?.notifyDataSetChanged()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(statusCode: Int, headers: Headers, response: String, throwable: Throwable) {
                Log.e(MoviesActivity::class.java.simpleName, "Error retrieving movies: ", throwable)
            }
        }]
    }

    companion object {
        private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
    }
}