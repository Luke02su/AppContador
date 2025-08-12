package com.example.contador

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private lateinit var textCounter: TextView
    private lateinit var btnIncrease: Button
    private lateinit var btnDecrease: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        textCounter = findViewById(R.id.textCounter)
        btnIncrease = findViewById(R.id.btnIncrease)
        btnDecrease = findViewById(R.id.btnDecrease)

        atualizarUI()

        btnIncrease.setOnClickListener {
            contador++
            atualizarUI()
        }

        btnDecrease.setOnClickListener {
            if (contador > 0) {
                contador--
                atualizarUI()
            }
        }
    }

    private fun atualizarUI() {
        textCounter.text = contador.toString()
        btnDecrease.isEnabled = contador > 0
    }
}