package com.curso.android.app.proyectofinal.compara_palabras.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.proyectofinal.compara_palabras.model.Comparador

class ComparadorViewModel : ViewModel() {

    private var model: Comparador? = null
    private val comparacionResultado = MutableLiveData<Boolean>()

    fun setPalabras(palabra1: String, palabra2: String){
        model = Comparador(palabra1, palabra2)
        comparacionResultado.value = model?.comparacion()
    }

    fun getResultadoComparacion(): Boolean {
        return model?.comparacion() ?: false
    }
}