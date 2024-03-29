package com.example.jetpack_submission1.di


import com.brillante.core.domain.usecase.FilmInteractor
import com.brillante.core.domain.usecase.FilmUseCase
import com.example.jetpack_submission1.ui.detail.DetailViewModel
import com.example.jetpack_submission1.ui.movie.MovieViewModel
import com.example.jetpack_submission1.ui.tvshow.TvViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val filmUseCaseModule = module {
    factory<FilmUseCase> {
        FilmInteractor(get())
    }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}