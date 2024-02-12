package com.example.tinkofffintech2024lab.presentation.favouritefilms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkofffintech2024lab.databinding.FragmentFavouriteFilmsBinding
import com.example.tinkofffintech2024lab.presentation.favouritefilms.adapter.FavouriteFilmsRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavouriteFilmsFragment : Fragment() {

    private var _binding: FragmentFavouriteFilmsBinding? = null
    private val binding get() = _binding!!

    private val favouriteFilmsViewModel by viewModel<FavouriteFilmsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            // recyclerView settings
            val adapter = FavouriteFilmsRecyclerViewAdapter(
                { film ->
                    val action = FavouriteFilmsFragmentDirections.actionFavouriteFilmsFragmentToFilmDetailsFragment(filmId = film.id)
                    findNavController().navigate(action)
                },
                { film ->
                    favouriteFilmsViewModel.updateFavouriteFilmStatus(film)
                    true
                }
            )
            recyclerViewFavouriteFilms.adapter = adapter
            val linearLayoutManager = LinearLayoutManager(this@FavouriteFilmsFragment.context)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerViewFavouriteFilms.layoutManager = linearLayoutManager
            recyclerViewFavouriteFilms.setHasFixedSize(true)

            // set adapter's list when new list fetched
            favouriteFilmsViewModel.filmsList.observe(viewLifecycleOwner) { newList ->
                adapter.submitList(newList)
            }

            favouriteFilmsViewModel.getFavouriteFilms()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}