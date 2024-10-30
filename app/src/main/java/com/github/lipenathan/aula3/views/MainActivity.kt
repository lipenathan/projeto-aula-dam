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

class MainActivity : AppCompatActivity() {

    private lateinit var textTitulo: TextView
    private lateinit var textConteudo: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textTitulo = findViewById(R.id.text_titulo)
        textConteudo = findViewById(R.id.text_conteudo)
        button = findViewById(R.id.button_acao)

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            result.data?.let {
                val p = it.getSerializableExtra("person_result") as Person
                textConteudo.text = p.toString()
            }
        }

        val intent = Intent(this, CadastroPessoaActivity::class.java)

        button.setOnClickListener {
            launcher.launch(intent)
        }

    }
}
