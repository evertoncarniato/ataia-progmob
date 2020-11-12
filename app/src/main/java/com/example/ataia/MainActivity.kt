package com.example.ataia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_next = findViewById<Button>(R.id.button_next)

        button_next.setOnClickListener() {
           changeActivity()
        }
    }

    private fun changeActivity() {
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}