package com.example.tinkofffintech2024lab.di

import com.example.data.datasource.local.LocalFilmsDataSource
import com.example.data.datasource.remote.FilmService
import com.example.data.datasource.remote.RemoteFilmsDataSource
import com.example.data.datasource.remote.RemoteFilmsDataSourceImpl
import com.example.data.repository.FilmRepositoryImpl
import com.example.domain.repository.FilmRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://kinopoiskapiunofficial.tech/api/"

val dataModule = module {

    single<FilmService> {
        val client = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FilmService::class.java)
    }

    single<RemoteFilmsDataSource> {
        RemoteFilmsDataSourceImpl(filmService = get())
    }

    single<FilmRepository> {
        FilmRepositoryImpl(
            remoteFilmsDataSource = get(),
            localFilmsDataSource = object : LocalFilmsDataSource {
                // todo implement localFilmsDataSource
            }
        )
    }

}