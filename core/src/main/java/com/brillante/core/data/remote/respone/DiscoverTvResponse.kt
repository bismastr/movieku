package com.brillante.core.data.remote.respone

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class DiscoverTvResponse(
    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("results")
    val results: List<TvResultsItem>,

    @field:SerializedName("total_results")
    val totalResults: Int
)

@Parcelize
data class TvResultsItem(

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("original_language")
    val originalLanguage: String,

    @field:SerializedName("genre_ids")
    val genreIds: List<Int>?,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("origin_country")
    val originCountry: List<String>?,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("popularity")
    val popularity: Double,

    @field:SerializedName("vote_average")
    val voteAverage: Double,

    @field:SerializedName("original_name")
    val originalName: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("vote_count")
    val voteCount: Int
) : Parcelable
