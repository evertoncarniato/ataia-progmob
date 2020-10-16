package com.example.ataia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input_duvida = findViewById<EditText>(R.id.input_duvida)

        val button_duvida = findViewById<Button>(R.id.button_duvida)

        button_duvida.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Consultando... " + input_duvida.text,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}