package com.example.flixster_k

import org.json.JSONArray

data class Movie(
    val MovieId: Int,
    private val posterPath : String,
    val title: String,
    val overview: String,
) {
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
//    allows ur to call methods on the movie class without having an instance
    companion object{
        fun fromJsonArray(movieJSONArray: JSONArray):List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJSONArray.length()){
                val movieJson = movieJSONArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}