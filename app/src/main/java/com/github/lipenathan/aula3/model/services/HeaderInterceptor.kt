package com.github.lipenathan.aula3.model.services

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val newRequest = request.newBuilder()
            .header("Novo-Header", "Valor Header")
            .build()

        return chain.proceed(newRequest)
    }
}