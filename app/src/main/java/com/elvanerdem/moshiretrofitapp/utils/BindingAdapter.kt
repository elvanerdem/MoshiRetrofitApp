package com.elvanerdem.moshiretrofitapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.elvanerdem.moshiretrofitapp.R
import com.elvanerdem.moshiretrofitapp.data.Movie
import com.elvanerdem.moshiretrofitapp.ui.MoviesAdapter


@BindingAdapter("movieList")
fun bindMoviesRecyclerView(recyclerView: RecyclerView, movieList: List<Movie>?) {
    val adapter = recyclerView.adapter as MoviesAdapter
    adapter.submitList(movieList)
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imagePath: String?) {
    val imgUri = "https://image.tmdb.org/t/p/w500$imagePath"
    Glide.with(imageView.context)
        .load(imgUri)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
        )
        .into(imageView)
}