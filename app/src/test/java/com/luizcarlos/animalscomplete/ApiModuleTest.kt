package com.luizcarlos.animalscomplete

import com.luizcarlos.animalscomplete.di.ApiModule
import com.luizcarlos.animalscomplete.api.AnimalApiService

class ApiModuleTest(val mockService : AnimalApiService) : ApiModule() {

    override fun providesAnimalService(): AnimalApiService {
        return mockService
    }
}