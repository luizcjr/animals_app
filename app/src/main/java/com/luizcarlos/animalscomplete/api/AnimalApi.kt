package com.luizcarlos.animalscomplete.api

import com.luizcarlos.animalscomplete.model.Animal
import com.luizcarlos.animalscomplete.model.ApiKey
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AnimalApi {

    @GET("getKey")
    fun getKey() : Single<ApiKey>

    @FormUrlEncoded
    @POST("getAnimals")
    fun getAnimals(@Field("key") key: String) : Single<List<Animal>>
}