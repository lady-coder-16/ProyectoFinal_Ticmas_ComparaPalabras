package com.curso.android.app.proyectofinal.compara_palabras.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.proyectofinal.compara_palabras.databinding.ActivityMainBinding
import com.curso.android.app.proyectofinal.compara_palabras.viewmodel.ComparadorViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ComparadorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ComparadorViewModel::class.java]

        viewModel.mensajeLiveData.observe(this) { mensaje ->
            // Actualiza la IU con el mensaje
            updateResultadoComparacion(mensaje)
        }

        binding.btnComparar.setOnClickListener {
            val palabra1 = binding.etPalabra1.text.toString()
            val palabra2 = binding.etPalabra2.text.toString()

            viewModel.setPalabras(palabra1, palabra2)

            viewModel.setMensajeResultado()
            ocultarTeclado(it)
        }
    }

    private fun updateResultadoComparacion(mensaje: String) {
        binding.textResultado.text = mensaje
    }

    private fun ocultarTeclado(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}


