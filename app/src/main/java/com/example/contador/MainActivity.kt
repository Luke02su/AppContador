package com.example.contador

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

// Classe principal da Activity que gerencia a interface do contador
class MainActivity : AppCompatActivity() {

    // Variável que guarda o valor atual do contador, inicializado em 0
    private var contador = 0

    // Declaração tardia (lateinit) das views para serem inicializadas no onCreate
    private lateinit var textCounter: TextView
    private lateinit var btnIncrease: Button
    private lateinit var btnDecrease: Button

    // Método chamado quando a Activity é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout XML a ser usado nesta Activity
        setContentView(R.layout.layout)

        // Inicializa as views buscando pelo ID definido no XML
        textCounter = findViewById(R.id.textCounter)
        btnIncrease = findViewById(R.id.btnIncrease)
        btnDecrease = findViewById(R.id.btnDecrease)

        // Atualiza a interface para refletir o estado inicial do contador
        atualizarUI()

        // Define o comportamento do botão "Aumentar" ao ser clicado
        btnIncrease.setOnClickListener {
            contador++               // Incrementa o contador em 1
            atualizarUI()            // Atualiza a interface para mostrar novo valor
        }

        // Define o comportamento do botão "Diminuir" ao ser clicado
        btnDecrease.setOnClickListener {
            if (contador > 0) {      // Verifica se o contador é maior que zero para não ir abaixo de zero
                contador--           // Decrementa o contador em 1
                atualizarUI()        // Atualiza a interface para mostrar novo valor
            }
        }
    }

    // Função que atualiza o texto e o estado dos botões na interface
    private fun atualizarUI() {
        textCounter.text = contador.toString()      // Exibe o valor atual do contador na TextView
        btnDecrease.isEnabled = contador > 0        // Desabilita o botão "Diminuir" se o contador for zero
    }
}
