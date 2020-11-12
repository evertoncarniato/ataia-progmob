package com.example.ataia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*
import org.jetbrains.anko.db.insert

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val input_question = findViewById<EditText>(R.id.input_question)

        button_question.setOnClickListener {
            database.use {
                val idQuestion = insert("question",
                    "question" to input_question.text.toString()
                )
                if (idQuestion != -1L) {
                    toast("Consultando... \n$idQuestion: ${input_question.text.toString()}")
                    input_question.text.clear()
                    showQuestions()
                } else {
                    toast("Erro ao inserir no banco de dados!")
                }
            }
        }

    }

    private fun showQuestions() {
        val intent = Intent(this, QuestionsListActivity::class.java)
        startActivity(intent)
    }

    private fun toast(menssage: String) {
        Toast.makeText(applicationContext, menssage, Toast.LENGTH_LONG).show()
    }
}