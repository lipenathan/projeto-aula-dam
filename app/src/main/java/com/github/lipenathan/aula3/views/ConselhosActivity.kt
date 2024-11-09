package com.github.lipenathan.aula3.views

import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.lipenathan.aula3.databinding.ActivityConselhosBinding
import com.github.lipenathan.aula3.model.services.AdvicesService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class ConselhosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConselhosBinding
    private lateinit var service: AdvicesService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConselhosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        service = AdvicesService()

        binding.buttonNovo.setOnClickListener {
            lifecycleScope.launch(exceptionHandler) {
                fetchAdvice()
            }
        }

        lifecycleScope.launch(exceptionHandler) {
            fetchAdvice()
        }
    }

    /**
     * método responsável por utilizar serviço REST criado para realizar chamada de conselhos aleatórios
     * LER README para Suspend Functions
     */
    private suspend fun fetchAdvice() {
        val response = service.getRandomAdvice()
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
}