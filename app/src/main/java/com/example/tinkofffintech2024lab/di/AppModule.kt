package com.example.tinkofffintech2024lab.di

import com.example.domain.usecase.GetPopularFilmsUseCase
import com.example.tinkofffintech2024lab.presentation.popularfilms.PopularFilmsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<PopularFilmsViewModel> {
        PopularFilmsViewModel(
            getPopularFilmsUseCase = GetPopularFilmsUseCase(get())
        )
    }

}