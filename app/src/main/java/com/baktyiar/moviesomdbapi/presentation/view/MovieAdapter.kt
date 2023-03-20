package com.baktyiar.moviesomdbapi.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.baktyiar.moviesomdbapi.presentation.model.Movie
import com.baktyiar.moviesomdbapi.databinding.MovieItemBinding
import com.bumptech.glide.Glide

class MoviesAdapter(private val onItemClicked: (Movie) -> Unit) :
    ListAdapter<Movie, MoviesAdapter.MovieHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.imdbId == newItem.imdbId
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val viewHolder = MovieHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MovieHolder(private var binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.title.text = movie.title
            binding.year.text = movie.year
            binding.type.text =     movie.type

            Glide.with(binding.root.context)
                .load(movie.poster)
                .override(300, 200)
                .error(android.R.drawable.stat_notify_error)
                .into(binding.poster);
        }
    }
}