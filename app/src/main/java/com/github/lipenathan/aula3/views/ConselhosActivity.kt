package com.github.lipenathan.aula3.views

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.lipenathan.aula3.databinding.ActivityConselhosBinding
import com.github.lipenathan.aula3.model.rest.AdvicesApi
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ConselhosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConselhosBinding
    private val service by lazy {
        createService()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConselhosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonNovo.setOnClickListener {
            lifecycleScope.launch(exceptionHandler) {
                fetchAdvices()
            }
        }

        lifecycleScope.launch(exceptionHandler) {
            fetchAdvices()
        }
    }

    private fun createService(): AdvicesApi {

        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(HeaderInterceptor())
            .build()

        return Retrofit.Builder().baseUrl("https://api.adviceslip.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build().create(AdvicesApi::class.java)
    }

    private suspend fun fetchAdvices() {
        val response = service.getRandomAdivice()
        if (response.isSuccessful) {
            response.body()?.let {
                binding.textConselho.text = it.slip.advice
            }
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val dialog = Dialog(this@ConselhosActivity)
        dialog.setTitle("Erro")
        dialog.setContentView(TextView(this@ConselhosActivity).apply {
            throwable.message
        })

        dialog.show()
    }

    inner class HeaderInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {

            val request = chain.request()
            val newRequest = request.newBuilder()
                .header("Novo-Header", "Valor Header")
                .build()

            return chain.proceed(newRequest)
        }
    }
}