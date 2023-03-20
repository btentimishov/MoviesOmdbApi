package com.baktyiar.moviesomdbapi.presentation.view

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baktyiar.moviesomdbapi.R
import com.baktyiar.moviesomdbapi.data.local.LocalEntityMapper
import com.baktyiar.moviesomdbapi.presentation.model.Movie
import com.baktyiar.moviesomdbapi.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MovieListFragment : Fragment() {
    val movies = listOf(
        Movie(
            "The Avengers",
            "2012",
            "tt0848228",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"
        ),
        Movie(
            "Inception",
            "2010",
            "tt1375666",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg"
        ),
        Movie(
            "The Dark Knight",
            "2008",
            "tt0468569",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg"
        ),
        Movie(
            "The Matrix",
            "1999",
            "tt0133093",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg"
        ),
        Movie(
            "Interstellar",
            "2014",
            "tt0816692",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BMjIxNTU4MzY4MF5BMl5BanBnXkFtZTgwMzM4ODI3MjE@._V1_SX300.jpg"
        ),
        Movie(
            "The Lord of the Rings: The Fellowship of the Ring",
            "2001",
            "tt0120737",
            "movie",
            "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg"
        )
    )
    private var _binding: FragmentMovieListBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.moviesList
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MoviesAdapter {
            Log.d("TEST", "Title: ${it.title} url: ${it.poster}")
        }
        lifecycleScope.launch() {
            lifecycle.coroutineScope.launch {
                viewModel.getAll().collect { it ->
                    adapter.submitList(it.map { LocalEntityMapper().mapFromEntity(it) })
                }
            }
        }

        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.queryHint = "Search a movie"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
//                viewModel.findMovie(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.findMovie(query)
                return false
            }
        })
    }
}