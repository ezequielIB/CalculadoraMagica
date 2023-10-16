package com.example.calculadoramagica

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variables para mantener el estado de la calculadora
    private var input: String = ""
    private var operator: String = ""
    private var firstValue: Double = 0.0

    // Vistas
    private lateinit var txtInput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buttons_ui)

        // Inicializa las vistas
        txtInput = findViewById(R.id.txtInput)
    }

    // Método para manejar los clics de los botones numéricos y el botón decimal
    fun onNumberClick(view: View) {
        if (view is Button) {
            val value = view.text.toString()
            input += value
            updateInput()
        }
    }

    // Método para manejar los clics de los botones de operadores (+, -, *, /)
    fun onOperatorClick(view: View) {
        if (view is Button) {
            operator = view.text.toString()
            firstValue = input.toDouble()
            input = ""
        }
    }

    // Método para manejar el clic del botón igual (=)
    fun onEqualsClick(view: View) {
        if (input.isNotEmpty()) {
            val secondValue = input.toDouble()
            val result = when (operator) {
                "+" -> firstValue + secondValue
                "-" -> firstValue - secondValue
                "*" -> firstValue * secondValue
                "/" -> if (secondValue != 0.0) firstValue / secondValue else Double.NaN
                else -> Double.NaN
            }
            input = result.toString()
            operator = ""
            updateInput()
        }
    }

    // Método para manejar el clic del botón Clear (C)
    fun onClearClick(view: View) {
        input = ""
        operator = ""
        firstValue = 0.0
        updateInput()
    }

    // Actualiza el campo de entrada en la vista
    private fun updateInput() {
        txtInput.text = input
    }
}