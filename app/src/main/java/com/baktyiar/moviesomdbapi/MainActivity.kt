package com.baktyiar.moviesomdbapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.Insets.add
import androidx.fragment.app.FragmentTransaction
import com.baktyiar.moviesomdbapi.presentation.view.MovieListFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val newFragment = MovieListFragment()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragment_container_view, newFragment).commit()
    }
}