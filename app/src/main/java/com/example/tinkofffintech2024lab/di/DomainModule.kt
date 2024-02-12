package com.example.tinkofffintech2024lab.di

import com.example.domain.usecase.GetPopularFilmsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetPopularFilmsUseCase> {
        GetPopularFilmsUseCase(filmRepository = get())
    }

}