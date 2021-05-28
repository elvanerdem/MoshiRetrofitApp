package com.elvanerdem.moshiretrofitapp.data

import kotlinx.coroutines.Deferred
import retrofit2.http.*

/**
 * Created by elvanerdem on 26.05.2021.
 */
interface MovieService {

    @GET("movie/popular/")
    fun getPopularMoviesAsync(@Query("api_key") apiKey: String, @Query("page") page: Int, @Query("language") language: String): Deferred<PopularMovieListResponse>

}