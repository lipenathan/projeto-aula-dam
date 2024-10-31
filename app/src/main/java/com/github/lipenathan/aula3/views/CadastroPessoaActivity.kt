package com.github.lipenathan.aula3.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.lipenathan.aula3.databinding.ActivityCadastroPessoaBinding
import com.github.lipenathan.aula3.entities.Person
import com.google.android.material.snackbar.Snackbar

class CadastroPessoaActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCadastroPessoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroPessoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCadastrar.setOnClickListener {
            val nome = binding.inputName.text.toString()
            val idade = binding.inputIdade.text.toString().toInt()

            val person = Person(nome, idade)

            Snackbar.make(binding.root, person.toString(), Snackbar.LENGTH_LONG).show()
        }
    }
}