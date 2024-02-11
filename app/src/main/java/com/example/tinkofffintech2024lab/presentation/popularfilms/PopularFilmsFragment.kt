package com.example.tinkofffintech2024lab.presentation.popularfilms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tinkofffintech2024lab.R
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

            buttonNavigateToFilmDetails.setOnClickListener {
                findNavController().navigate(R.id.action_popularFilmsFragment_to_filmDetailsFragment)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}