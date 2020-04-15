package com.luizcarlos.animalscomplete.di

import com.luizcarlos.animalscomplete.viewmodel.ListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, PrefsModule::class, AppModule::class])
interface ViewModelComponent {
    fun inject(viewModel:ListViewModel)
}