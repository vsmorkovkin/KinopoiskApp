package com.example.tinkofffintech2024lab.presentation.unavailablenetwork

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.tinkofffintech2024lab.R
import com.example.tinkofffintech2024lab.databinding.FragmentUnavailableNetworkBinding
import com.example.tinkofffintech2024lab.utils.NetworkUtils


class UnavailableNetworkFragment : Fragment() {

    private var _binding: FragmentUnavailableNetworkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUnavailableNetworkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            buttonRetry.setOnClickListener {
                if (NetworkUtils.isNetworkAvailable(view.context)) {
                    findNavController().navigate(R.id.popularFilmsFragment, null,
                        NavOptions.Builder()
                            .setPopUpTo(R.id.popularFilmsFragment, true)
                            .build()
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}