package com.example.calculadoramagica

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {

    private lateinit var inputText: TextView
    private var input = ""
    private var firstValue = 0.0
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buttons_ui)

        inputText = findViewById(R.id.txtInput) // Asegúrate de que el ID sea el correcto
    }

    fun onNumberClick(view: View) {
        if (view is Button) {
            val value = view.text.toString()
            input += value
            updateInputText()
        }
    }

    fun onOperatorClick(view: View) {
        if (view is Button) {
            operator = view.text.toString()
            firstValue = input.toDouble()
            input = ""
        }
    }

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
            updateInputText()
        }
    }

    fun onClearClick(view: View) {
        input = ""
        operator = ""
        firstValue = 0.0
        updateInputText()
    }

    private fun updateInputText() {
        inputText.text = input
    }
}
