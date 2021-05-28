package com.elvanerdem.moshiretrofitapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvanerdem.moshiretrofitapp.data.Movie
import com.elvanerdem.moshiretrofitapp.data.MovieRepository
import kotlinx.coroutines.launch

/**
 * Created by elvanerdem on 26.05.2021.
 */
class MainViewModel : ViewModel() {

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>>
        get() = _movieList

    init {
        getMovieList()
    }

    private fun getMovieList() {
        viewModelScope.launch {
            _movieList.value = MovieRepository().getPopularMovies(1)
            Log.d("DATA: ", _movieList.value?.size.toString())
        }
    }

}