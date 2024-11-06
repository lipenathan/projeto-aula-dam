package com.github.lipenathan.aula3.model.rest

import com.github.lipenathan.aula3.model.entities.Advice
import retrofit2.Response
import retrofit2.http.GET

interface AdvicesApi {

    @GET("advice")
    suspend fun getRandomAdivice(): Response<Advice>
}