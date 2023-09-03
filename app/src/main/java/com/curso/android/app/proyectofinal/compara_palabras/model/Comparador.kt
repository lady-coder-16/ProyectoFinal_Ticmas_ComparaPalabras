package com.curso.android.app.proyectofinal.compara_palabras.model

data class Comparador(val palabra1: String, val palabra2: String) {
    fun comparacion(): Boolean {
        return palabra1 == palabra2
    }
}