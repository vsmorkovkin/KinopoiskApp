package com.example.tinkofffintech2024lab.presentation.popularfilms

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Film
import com.example.tinkofffintech2024lab.databinding.FilmItemBinding

class PopularFilmsRecyclerViewAdapter(
    private val filmList: List<Film>
) : RecyclerView.Adapter<PopularFilmsRecyclerViewAdapter.PopularFilmsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFilmsViewHolder {
        val binding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularFilmsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularFilmsViewHolder, position: Int) {
        val film = filmList[position]
        holder.bind(film)
    }

    override fun getItemCount(): Int = filmList.size

    class PopularFilmsViewHolder(private val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(film: Film) {
            binding.textViewFilmTitle.text = film.title
            binding.textViewFilmGenreYear.text = "${film.genre}(${film.year})"
            binding.imageViewFavouriteIndicator.visibility = if (film.inFavourites) View.VISIBLE else View.GONE
        }

    }
}