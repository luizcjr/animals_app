package com.luizcarlos.animalscomplete.di

import com.luizcarlos.animalscomplete.api.AnimalApiService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: AnimalApiService)
}