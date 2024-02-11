package com.example.tinkofffintech2024lab.presentation.popularfilms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.Film
import com.example.tinkofffintech2024lab.databinding.FragmentPopularFilmsBinding


class PopularFilmsFragment : Fragment() {

    private var _binding: FragmentPopularFilmsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            val filmList = mutableListOf<Film>()
            for (i in 0..5) {
                filmList.add(Film(
                    title = "Title$i",
                    genre = "Genre",
                    year = 2020 + i,
                    imageUrl = "",
                    inFavourites = false
                ))
            }
            recyclerViewPopularFilms.adapter = PopularFilmsRecyclerViewAdapter(filmList)
            val linearLayoutManager = LinearLayoutManager(this@PopularFilmsFragment.context)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerViewPopularFilms.layoutManager = linearLayoutManager
            recyclerViewPopularFilms.setHasFixedSize(true)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}