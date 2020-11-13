package com.example.ataia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_questions_list.*
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.rowParser
import org.jetbrains.anko.db.select

class QuestionsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_list)

        val questionsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        list_view_questions.adapter = questionsAdapter

        database.use {
            select("question").exec {
                val parser = rowParser() {
                        id: Int,
                        question: String -> Question(id, question)
                }
                var questionsList = parseList(parser)

                questionsAdapter.clear()
                val textQuestions = questionsList.map { it.question }
                questionsAdapter.addAll(textQuestions)
            }
        }

        list_view_questions.setOnItemClickListener { parent, view, position, id ->
            Log.d("Debug", "${position}, ${id}")
//            val intent = Intent(this, MapsActivity::class.java)
//            startActivity(intent)
            val intent = Intent(this, PhotoActivity::class.java)
            startActivity(intent)
        }
    }
}