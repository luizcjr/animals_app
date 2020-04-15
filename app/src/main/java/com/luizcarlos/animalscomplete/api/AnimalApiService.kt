package com.luizcarlos.animalscomplete.api

import com.luizcarlos.animalscomplete.di.DaggerApiComponent
import com.luizcarlos.animalscomplete.model.Animal
import com.luizcarlos.animalscomplete.model.ApiKey
import io.reactivex.Single
import javax.inject.Inject

class AnimalApiService {

    @Inject
    lateinit var api: AnimalApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getApiKey():Single<ApiKey> {
        return api.getKey()
    }

    fun getAnimals(key: String) : Single<List<Animal>> {
        return api.getAnimals(key)
    }
}