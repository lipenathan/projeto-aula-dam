package com.github.lipenathan.aula3.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.github.lipenathan.aula3.databinding.ActivityMainBinding
import com.github.lipenathan.aula3.entities.Person
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val coroutine: CoroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val job = coroutine.launch {
            delay(5000)
            repeat(10) { i ->
                delay(5000)
                Snackbar.make(binding.root, "Loop $i", Snackbar.LENGTH_SHORT).show()
            }
        }

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            //será executado após a acitivty que está iniciar for finalizada

            if (result.data != null && result.resultCode == RESULT_OK) {
                val person = result.data!!.getSerializableExtra("cadastro_result") as Person
                binding.textConteudo.text = person.toString()
            }
            job.cancel()
        }

        binding.apply {
            if (savedInstanceState != null) {
                textConteudo.text = savedInstanceState.getString(textConteudo.id.toString())
            }

            buttonAcao.setOnClickListener {
                val text = inputUsuario.text.toString()
                textConteudo.text = text

                val intent = Intent(this@MainActivity, CadastroPessoaActivity::class.java)

                launcher.launch(intent)
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val value = binding.textConteudo.text.toString()
        outState.putString(binding.textConteudo.id.toString(), value)
    }

    //region ciclo de vida

    override fun onResume() {
        super.onResume()
        Log.i("CICLO_DE_VIDA", "Ciclo de vida ON RESUME")
    }

    override fun onStart() {
        super.onStart()
        Log.i("CICLO_DE_VIDA", "Ciclo de vida ON START")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CICLO_DE_VIDA", "Ciclo de vida ON STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CICLO_DE_VIDA", "Ciclo de vida ON DESTROY")
    }
    //endregion
}
