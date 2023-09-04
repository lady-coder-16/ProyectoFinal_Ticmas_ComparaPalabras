package com.curso.android.app.proyectofinal.compara_palabras

import android.support.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.proyectofinal.compara_palabras.view.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testCompararPalabras() {
        // Ingresa palabras en los campos de texto
        Espresso.onView(ViewMatchers.withId(R.id.et_palabra1))
            .perform(ViewActions.typeText("hello"))
        Espresso.onView(ViewMatchers.withId(R.id.et_palabra2))
            .perform(ViewActions.typeText("world"))

        // Presiona el botón
        Espresso.onView(ViewMatchers.withId(R.id.btn_comparar)).perform(ViewActions.click())

        // Verifica el resultado en el TextView
        Espresso.onView(ViewMatchers.withId(R.id.text_resultado))
            .check(ViewAssertions.matches(ViewMatchers.withText("False.\nSon Distintas.")))
    }
}