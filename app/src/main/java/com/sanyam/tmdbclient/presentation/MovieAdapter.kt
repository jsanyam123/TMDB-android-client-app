package com.sanyam.tmdbclient.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sanyam.tmdbclient.R
import com.sanyam.tmdbclient.data.model.movie.Movie
import com.sanyam.tmdbclient.databinding.ListItemBinding
import com.bumptech.glide.Glide


class MovieAdapter():RecyclerView.Adapter<MyMovieViewHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setList(movies:List<Movie>){
         movieList.clear()
         movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyMovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyMovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyMovieViewHolder, position: Int) {
       holder.bind(movieList[position])
    }
}



class MyMovieViewHolder(val binding: ListItemBinding):
RecyclerView.ViewHolder(binding.root){

   fun bind(movie:Movie){
        binding.titleTextView.text = movie.title
        val posterURL = "https://image.tmdb.org/t/p/w500"+movie.posterPath
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

   }

}