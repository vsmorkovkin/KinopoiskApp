package com.example.tinkofffintech2024lab.presentation.filmdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.tinkofffintech2024lab.R
import com.example.tinkofffintech2024lab.databinding.FragmentFilmDetailsBinding
import com.example.tinkofffintech2024lab.utils.NetworkUtils
import org.koin.androidx.viewmodel.ext.android.viewModel


class FilmDetailsFragment : Fragment() {

    private var _binding: FragmentFilmDetailsBinding? = null
    private val binding get() = _binding!!

    private val filmDetailsViewModel by viewModel<FilmDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            // assign viewModel from layout
            viewModel = filmDetailsViewModel
            lifecycleOwner = viewLifecycleOwner

            // Is the Internet available?
            val filmId = FilmDetailsFragmentArgs.fromBundle(requireArguments()).filmId
            if (NetworkUtils.isNetworkAvailable(view.context)) {
                // get film info
                filmDetailsViewModel.getFilmInfo(filmId = filmId)
            } else {
                // navigate to unavailableNetworkFragment
                findNavController().navigate(R.id.action_filmDetailsFragment_to_unavailableNetworkFragment)
            }

            // observe imageUrl changing
            filmDetailsViewModel.filmImageUrl.observe(viewLifecycleOwner) { newFilmImageUrl ->
                // Is the Internet available?
                if (NetworkUtils.isNetworkAvailable(view.context)) {
                    // load film image
                    Glide.with(view.context)
                        .load(newFilmImageUrl)
                        .into(imageViewFilmDetails)
                } else {
                    // navigate to unavailableNetworkFragment
                    findNavController().navigate(R.id.action_filmDetailsFragment_to_unavailableNetworkFragment)
                }
            }

            // observe filmGenres changing
            filmDetailsViewModel.filmGenres.observe(viewLifecycleOwner) { genresList ->
                val genresString = getString(R.string.film_details_genres, filmDetailsViewModel.listToString(genresList))
                textViewFilmDetailsGenres.text = genresString
            }

            // observe filmCountries changing
            filmDetailsViewModel.filmCountries.observe(viewLifecycleOwner) { countriesList ->
                val countriesString = getString(R.string.film_details_countries, filmDetailsViewModel.listToString(countriesList))
                textViewFilmDetailsCounties.text = countriesString
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}