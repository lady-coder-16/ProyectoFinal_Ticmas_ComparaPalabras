package com.curso.android.app.proyectofinal.compara_palabras.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.proyectofinal.compara_palabras.model.Comparador

class ComparadorViewModel : ViewModel() {

    private var model: Comparador? = null

    private val _mensajeLiveData = MutableLiveData<String>()
    val mensajeLiveData: LiveData<String> get() = _mensajeLiveData


    fun setPalabras(palabra1: String, palabra2: String) {
        model = Comparador(palabra1, palabra2)
        setMensajeResultado()
    }

    private fun getResultadoComparacion(): Boolean {
        return model?.comparacion() ?: false
    }

    fun setMensajeResultado() {
        if (getResultadoComparacion()) {
            _mensajeLiveData.value = "True.\nSon Iguales."
        } else {
            _mensajeLiveData.value = "False.\nSon Distintas."

        }
    }
    fun camposValidos(palabra1: String, palabra2: String):Boolean {
        return palabra1.isNotBlank() && palabra2.isNotBlank()
    }

}