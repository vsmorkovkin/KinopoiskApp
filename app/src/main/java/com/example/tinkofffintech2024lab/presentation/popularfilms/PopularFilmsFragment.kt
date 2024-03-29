package com.example.tinkofffintech2024lab.presentation.popularfilms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkofffintech2024lab.R
import com.example.tinkofffintech2024lab.databinding.FragmentPopularFilmsBinding
import com.example.tinkofffintech2024lab.utils.NetworkUtils
import org.koin.androidx.viewmodel.ext.android.viewModel


class PopularFilmsFragment : Fragment() {

    private var _binding: FragmentPopularFilmsBinding? = null
    private val binding get() = _binding!!

    private val popularFilmsViewModel by viewModel<PopularFilmsViewModel>()

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

            // recyclerView settings
            val adapter = PopularFilmsRecyclerViewAdapter(
                { film ->
                    val action = PopularFilmsFragmentDirections.actionPopularFilmsFragmentToFilmDetailsFragment(
                        filmId = film.id
                    )
                    findNavController().navigate(action)
                },
                { film ->
                    popularFilmsViewModel.updateFilmFavouriteStatus(film)
                    true
                }
            )
            recyclerViewPopularFilms.adapter = adapter
            val linearLayoutManager = LinearLayoutManager(this@PopularFilmsFragment.context)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerViewPopularFilms.layoutManager = linearLayoutManager
            recyclerViewPopularFilms.setHasFixedSize(true)

            // set adapter's list when new list fetched
            popularFilmsViewModel.filmsList.observe(viewLifecycleOwner) { newList ->
                adapter.setFilmList(newList)
            }

            popularFilmsViewModel.updatedFilmFavouriteStatus.observe(viewLifecycleOwner) { wasUpdated ->
                if (wasUpdated) {
                    adapter.itemChanged()
                }
            }

            // Is the Internet available?
            if (NetworkUtils.isNetworkAvailable(view.context)) {
                // fetch popular films
                popularFilmsViewModel.getPopularFilms()
            } else {
                // navigate to unavailableNetworkFragment
                findNavController().navigate(R.id.action_popularFilmsFragment_to_unavailableNetworkFragment)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}