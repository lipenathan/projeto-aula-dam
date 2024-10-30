package com.github.lipenathan.aula3.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.github.lipenathan.aula3.R
import com.github.lipenathan.aula3.entities.Person
import com.google.android.material.snackbar.Snackbar

class CadastroPessoaActivity : AppCompatActivity() {

    private lateinit var textNome: TextView
    private lateinit var textIdade: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_pessoa)

        textNome = findViewById(R.id.text_nome)
        textIdade = findViewById(R.id.text_idade)
        button = findViewById(R.id.button_cadastrar)

        button.setOnClickListener {
            val nome = textNome.text.toString()
            val idade = textIdade.text.toString()
            if (nome.isEmpty()) {
                Snackbar.make(button, "Preencha o nome", Snackbar.LENGTH_LONG).show()
            } else if (idade.isEmpty()) {
                Snackbar.make(button, "Preencha a idade", Snackbar.LENGTH_LONG).show()
            } else {
                val pessoa = Person(nome, idade.toInt())
                val intent = Intent()
                intent.putExtra("person_result", pessoa)
                setResult(RESULT_OK, intent)
                finish()
            }


        }
    }
}
