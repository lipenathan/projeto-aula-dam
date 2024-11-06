package com.github.lipenathan.aula3.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.lipenathan.aula3.databinding.ActivityCadastroPessoaBinding
import com.github.lipenathan.aula3.entities.Person
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CadastroPessoaActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCadastroPessoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroPessoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            repeat(50) { i ->
                delay(5000)
                val loop = "Loop $i"
                Log.i("COROUTINE", loop)
                Snackbar.make(binding.root, loop, Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.buttonCadastrar.setOnClickListener {
            val nome = binding.inputName.text.toString()
            val idade = binding.inputIdade.text.toString().toInt()

            val person = Person(nome, idade)

            val intent = Intent()
            intent.putExtra("result_person", person)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}