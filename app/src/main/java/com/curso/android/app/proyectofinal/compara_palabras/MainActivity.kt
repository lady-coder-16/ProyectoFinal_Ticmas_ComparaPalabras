package com.curso.android.app.proyectofinal.compara_palabras

import android.R
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.proyectofinal.compara_palabras.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val palabra1 = binding.etPalabra1
        val palabra2 = binding.etPalabra2
        val btnComparar = binding.btnComparar

        btnComparar.setOnClickListener {
            it.ocultarTeclado()

            if (palabra1.text.toString() == palabra2.text.toString()) {
                binding.textResultado.text = ("True. Son Iguales")
                //Mensaje pop up
                Toast.makeText(
                    applicationContext, "Son Iguales",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                binding.textResultado.text = "False. NO son Iguales"
                //Mensaje pop up
                Toast.makeText(
                    applicationContext, "NO son Iguales!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }

    fun View.ocultarTeclado(){
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.btnComparar.getWindowToken(), 0)
    }

}