package com.example.tinkofffintech2024lab.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.tinkofffintech2024lab.R
import com.example.tinkofffintech2024lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.apply {
            setSupportActionBar(toolbar) // use toolbar like the app's default app bar

            // setup toolbar with navController
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController
            val appBarConfiguration = AppBarConfiguration(
                setOf(R.id.popularFilmsFragment, R.id.favouriteFilmsFragment)
            )
            NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

            // hide button when move to FilmDetailsFragment
            navController.addOnDestinationChangedListener { _, destination, _ ->
                if (destination.id == R.id.filmDetailsFragment || destination.id == R.id.unavailableNetworkFragment) {
                    toolbar.title = ""
                    buttonPopularFilms.visibility = View.GONE
                    buttonFavouriteFilms.visibility = View.GONE
                } else {
                    buttonPopularFilms.visibility = View.VISIBLE
                    buttonFavouriteFilms.visibility = View.VISIBLE
                }
            }

            // move to PopularFilmsFragment when click on buttonPopularFilms
            buttonPopularFilms.setOnClickListener {
                navController.navigate(R.id.popularFilmsFragment, null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.popularFilmsFragment, true)
                        .build()
                )
            }

            // move to FavouriteFilmsFragment when click on buttonFavouriteFilms
            buttonFavouriteFilms.setOnClickListener {
                navController.navigate(R.id.favouriteFilmsFragment, null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.favouriteFilmsFragment, true)
                        .build()
                )
            }
        }
    }

}