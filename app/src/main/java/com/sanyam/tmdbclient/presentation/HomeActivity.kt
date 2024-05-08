package com.sanyam.tmdbclient.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanyam.tmdbclient.R
import com.sanyam.tmdbclient.databinding.ActivityHomeBinding
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: HomeViewModelFactory
    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var tvAdapter: TvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        (application as App).appComponent
            .inject(this)

        homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
        initRecyclerView()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = homeViewModel.getUpdatedMovies()
        response.observe(this, Observer {
            if(it!=null){
                movieAdapter.setList(it)
                movieAdapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
            }
        })
    }

    private fun updateTvShows() {
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val response = homeViewModel.getUpdatedTvShows()
        response.observe(this, Observer {
            if(it!=null){
                tvAdapter.setList(it)
                tvAdapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE
            }else{
                binding.tvshowProgressBar.visibility = View.GONE
            }
        })
    }



    private fun initRecyclerView() {
        val layoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.moviesRecyclerView.layoutManager = layoutManager1
        movieAdapter = MovieAdapter()
        binding.moviesRecyclerView.adapter = movieAdapter
        displayPopularMovies()

        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        tvAdapter = TvAdapter()
        binding.tvshowsRecyclerView.layoutManager = layoutManager2
        binding.tvshowsRecyclerView.adapter = tvAdapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.tvshowProgressBar.visibility = View.VISIBLE
        val responseLiveData = homeViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                tvAdapter.setList(it)
                tvAdapter.notifyDataSetChanged()
                binding.tvshowProgressBar.visibility = View.GONE
            } else {
                binding.tvshowProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = homeViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                movieAdapter.setList(it)
                movieAdapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })

    }
}