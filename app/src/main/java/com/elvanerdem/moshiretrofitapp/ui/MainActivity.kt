package com.elvanerdem.moshiretrofitapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.elvanerdem.moshiretrofitapp.R
import com.elvanerdem.moshiretrofitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel

        binding.rvMovies.adapter = MoviesAdapter(MoviesAdapter.OnClickListener {
            Toast.makeText(this, "${it.orgTitle} clicked", Toast.LENGTH_SHORT).show()
        })
    }
}

