package com.example.tinkofffintech2024lab.di

import com.example.tinkofffintech2024lab.presentation.favouritefilms.FavouriteFilmsViewModel
import com.example.tinkofffintech2024lab.presentation.filmdetails.FilmDetailsViewModel
import com.example.tinkofffintech2024lab.presentation.popularfilms.PopularFilmsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<PopularFilmsViewModel> {
        PopularFilmsViewModel(
            getPopularFilmsUseCase = get(),
            updateFilmFavouriteStatusUseCase = get()
        )
    }

    viewModel<FavouriteFilmsViewModel> {
        FavouriteFilmsViewModel(
            getFavouriteFilmsUseCase = get(),
            updateFilmFavouriteStatusUseCase = get()
        )
    }

    viewModel<FilmDetailsViewModel> {
        FilmDetailsViewModel(
            getFilmInfoUseCase = get()
        )
    }

}