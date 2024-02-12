package com.example.tinkofffintech2024lab.di

import com.example.domain.usecase.GetFavouriteFilmsUseCase
import com.example.domain.usecase.GetPopularFilmsUseCase
import com.example.domain.usecase.UpdateFilmFavouriteStatusUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetPopularFilmsUseCase> {
        GetPopularFilmsUseCase(filmRepository = get())
    }

    factory<UpdateFilmFavouriteStatusUseCase> {
        UpdateFilmFavouriteStatusUseCase(filmRepository = get())
    }

    factory<GetFavouriteFilmsUseCase> {
        GetFavouriteFilmsUseCase(filmRepository = get())
    }

}