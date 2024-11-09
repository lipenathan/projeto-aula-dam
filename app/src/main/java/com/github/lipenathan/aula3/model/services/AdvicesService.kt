package com.github.lipenathan.aula3.model.services

import com.github.lipenathan.aula3.model.entities.Advice
import com.github.lipenathan.aula3.model.rest.AdvicesApi
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Serviço Retrofit para criar REST de chamadas de API públicas de conselhos
 */
class AdvicesService {

    private val api: AdvicesApi

    init {
        //criação do client para nossas chamadas REST
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HeaderInterceptor())
            .build()

        api = Retrofit.Builder().baseUrl("https://api.adviceslip.com/")//URL base das nossas chamadas para a API
            .addConverterFactory(GsonConverterFactory.create()) //conversor responsável por realizar parse de json para objeto kotlin
            .client(client)
            .build().create(AdvicesApi::class.java)
    }

    /**
     * Chamada suspensa para busca de conselhos aleátórios
     * LER README para Suspend Functions
     */
    suspend fun getRandomAdvice(): Response<Advice> {
        return api.getRandomAdvice()
    }
}