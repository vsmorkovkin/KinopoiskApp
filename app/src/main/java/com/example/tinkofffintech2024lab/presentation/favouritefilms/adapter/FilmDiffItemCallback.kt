package com.example.tinkofffintech2024lab.presentation.favouritefilms.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.Film

class FilmDiffItemCallback : DiffUtil.ItemCallback<Film>() {
    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean
            = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean
            = oldItem == newItem
}