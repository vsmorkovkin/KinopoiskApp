package com.example.tinkofffintech2024lab.presentation.popularfilms

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.Film
import com.example.tinkofffintech2024lab.databinding.FilmItemBinding

class PopularFilmsRecyclerViewAdapter(
    private val onClick: (film: Film) -> Unit,
    private val onLongClick: (film: Film) -> Boolean
) : RecyclerView.Adapter<PopularFilmsRecyclerViewAdapter.PopularFilmsViewHolder>() {

    private var filmList = emptyList<Film>()

    @SuppressLint("NotifyDataSetChanged")
    fun setFilmList(filmList: List<Film>) {
        this.filmList = filmList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFilmsViewHolder {
        val binding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularFilmsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularFilmsViewHolder, position: Int) {
        val film = filmList[position]
        holder.bind(film, onClick, onLongClick, position, this::setToUpdatePosition )
    }

    override fun getItemCount(): Int = filmList.size

    class PopularFilmsViewHolder(private val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(
            film: Film,
            onClick: (film: Film) -> Unit,
            onLongClick: (film: Film) -> Boolean,
            position: Int,
            setToUpdatePosition: (position: Int) -> Unit
        ) {
            binding.textViewFilmTitle.text = film.title
            binding.textViewFilmGenreYear.text = "${film.genre} (${film.year})"
            binding.imageViewFavouriteIndicator.visibility = if (film.inFavourites) View.VISIBLE else View.GONE

            Glide.with(binding.root.context)
                .load(film.imageUrl)
                .into(binding.imageViewFilm)

            binding.root.setOnClickListener { onClick(film) }
            binding.root.setOnLongClickListener {
                onLongClick(film)
                film.inFavourites = !film.inFavourites
                setToUpdatePosition(position)
                true
            }
        }

    }

    private var toUpdatePosition = -1

    private fun setToUpdatePosition(position: Int) {
        toUpdatePosition = position
    }

    fun itemChanged() {
        notifyItemChanged(toUpdatePosition)
    }


}