package com.curso.android.app.proyectofinal.compara_palabras

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.proyectofinal.compara_palabras.model.Comparador
import com.curso.android.app.proyectofinal.compara_palabras.viewmodel.ComparadorViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ComparadorViewModelUnitTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: ComparadorViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = ComparadorViewModel()
    }

    @Test
    fun `comparacionResultadoLiveData deberia contener mensaje de que ambas palabras son iguales`() {
        val model = Comparador("hola", "hola")
        viewModel.compararPalabras(model)
        assert(viewModel.comparacionResultadoLiveData.value == "True.\nSon Iguales.")
    }

    @Test
    fun `comparacionResultadoLiveData deberia contener mensaje de que ambas palabras son distintas`() {
        val model = Comparador("hola", "mundo")
        viewModel.compararPalabras(model)
        assert(viewModel.comparacionResultadoLiveData.value == "False.\nSon Distintas.")
    }

    @Test
    fun `comparisonResultLiveData deberia contener mensaje de Completar Todos los Campos`() {
        val model = Comparador("", "")
        viewModel.compararPalabras(model)
        assert(viewModel.comparacionResultadoLiveData.value == "Ambos campos son obligatorios")
    }
}