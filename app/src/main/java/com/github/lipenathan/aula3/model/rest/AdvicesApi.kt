package com.github.lipenathan.aula3.model.rest

import com.github.lipenathan.aula3.model.entities.Advice
import retrofit2.Response
import retrofit2.http.GET

/**
 * Interface para chamadas da API, que o Retrofit irá utilizar para implementar um ponto de acesso/serviço para chamadas REST
 */
interface AdvicesApi {

    /**
     * Chamada REST utiliazando método GET
     */
    @GET("advice")
    suspend fun getRandomAdvice(): Response<Advice>
}