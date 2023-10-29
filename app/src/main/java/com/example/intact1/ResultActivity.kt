package com.example.intact1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class ResultActivity : AppCompatActivity() {

    var arrSO = arrayOf(
        "Android", "iPhone", "Windows Phone", "Blackberry", "Firefox OS", "Amazon World", "Nokia"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val message = intent.getStringExtra("param")
        val tvResult: TextView = findViewById(R.id.tvResult)
        tvResult.text = message

        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val lsvSistemasOperativos: ListView = findViewById(R.id.lsvSO)
        val adaptador: Any? = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1,arrSO)

        lsvSistemasOperativos.adapter = adaptador as ListAdapter?

        lsvSistemasOperativos.setOnItemClickListener { parent, view, position, id ->
            println("Aqui mostraré un mensaje al usuario")
            Toast.makeText(
                applicationContext,"La posicion seleccionada es: $position", Toast.LENGTH_SHORT
            ).show()
        }

    }
}