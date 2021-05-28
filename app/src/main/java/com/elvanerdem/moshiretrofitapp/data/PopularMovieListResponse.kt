package com.elvanerdem.moshiretrofitapp.data

import com.squareup.moshi.Json

/**
 * Created by elvanerdem on 26.05.2021.
 */
data class PopularMovieListResponse(
    val page: Int,
    val results: List<Movie>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)