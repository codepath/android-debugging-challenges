package com.codepath.debuggingchallenges.models

import org.json.JSONObject
import org.json.JSONArray
import org.json.JSONException
import java.util.ArrayList

class Movie(jsonObject: JSONObject) {
    val title: String = jsonObject.getString("original_title")
    val posterUrl: String = String.format("https://image.tmdb.org/t/p/w342/%s", jsonObject.getString("poster_path"))
    val rating: Double = jsonObject.getDouble("vote_average")

    companion object {
        fun fromJSONArray(jsonArray: JSONArray): ArrayList<Movie> {
            val results = ArrayList<Movie>()
            for (i in 0 until jsonArray.length()) {
                try {
                    results.add(Movie(jsonArray.getJSONObject(i)))
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
            return results
        }
    }
}