package com.example.tinkofffintech2024lab.presentation.favouritefilms.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.Film
import com.example.tinkofffintech2024lab.databinding.FilmItemBinding

class FavouriteFilmsRecyclerViewAdapter(
    private val onClick: (film: Film) -> Unit,
    private val onLongClick: (film: Film) -> Boolean
) : ListAdapter<Film, FavouriteFilmsRecyclerViewAdapter.FavouriteFilmsViewHolder>(FilmDiffItemCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteFilmsViewHolder {
        val binding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouriteFilmsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavouriteFilmsViewHolder, position: Int) {
        val film = getItem(position)
        holder.bind(film, onClick, onLongClick)
    }

    class FavouriteFilmsViewHolder(private val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {
        
        @SuppressLint("SetTextI18n")
        fun bind(
            film: Film,
            onClick: (film: Film) -> Unit,
            onLongClick: (film: Film) -> Boolean,
        ) {
            binding.apply {
                textViewFilmTitle.text = film.title
                textViewFilmGenreYear.text = "${film.genre} (${film.year})"
                imageViewFavouriteIndicator.visibility = if (film.inFavourites) View.VISIBLE else View.GONE

                Glide.with(root.context)
                    .load(film.imageUrl)
                    .into(binding.imageViewFilm)

                root.setOnClickListener { onClick(film) }
                root.setOnLongClickListener {
                    onLongClick(film)
                    true
                }
            }
        }
        
    }

}