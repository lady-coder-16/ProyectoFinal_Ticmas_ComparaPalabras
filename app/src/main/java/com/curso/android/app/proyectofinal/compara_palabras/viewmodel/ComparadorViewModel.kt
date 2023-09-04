package com.curso.android.app.proyectofinal.compara_palabras.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.proyectofinal.compara_palabras.model.Comparador
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ComparadorViewModel : ViewModel() {

    private val _comparacionResultadoLiveData = MutableLiveData<String>()
    val comparacionResultadoLiveData: LiveData<String> get() = _comparacionResultadoLiveData

    fun compararPalabras(model: Comparador){
        if(model.palabra1.isBlank() || model.palabra2.isBlank()){
            _comparacionResultadoLiveData.value = "Completa Todos los Campos"
            return
        }

        GlobalScope.launch(Dispatchers.Default){
            val resultado = if (model.palabra1 == model.palabra2){
                "True.\nSon Iguales."
            }else{
                "False.\nSon Distintas."
            }
            _comparacionResultadoLiveData.postValue(resultado)
        }
    }
// --------
/*    fun setPalabras(palabra1: String, palabra2: String) {
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
    }*/

}