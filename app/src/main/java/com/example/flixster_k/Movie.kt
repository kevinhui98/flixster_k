package com.example.flixster_k

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import org.json.JSONArray

@Parcelize
data class Movie(
    val MovieId: Int,
    val voteAverage: Double,
    private val posterPath : String,
    private val backdrop_path : String,
    val title: String,
    val overview: String,
) : Parcelable {
    @IgnoredOnParcel
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    @IgnoredOnParcel
    val backPosterImageUrl = "https://image.tmdb.org/t/p/w342/$backdrop_path"
//    allows ur to call methods on the movie class without having an instance
    companion object{
        fun fromJsonArray(movieJSONArray: JSONArray):List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJSONArray.length()){
                val movieJson = movieJSONArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getDouble("vote_average"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("backdrop_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}