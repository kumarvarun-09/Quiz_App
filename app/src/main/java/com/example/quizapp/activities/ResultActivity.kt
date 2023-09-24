package com.example.quizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quizapp.R
import com.example.quizapp.constants.Constants

class ResultActivity : AppCompatActivity() {
    private var username: TextView? = null
    private var scoreTV: TextView? = null
    private var finish: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        username = findViewById(R.id.username)
        scoreTV = findViewById(R.id.score)
        finish = findViewById(R.id.finish)

        username?.text = intent.getStringExtra(Constants.USER_NAME)
        val score = intent.getStringExtra(Constants.SCORE)
        val total = intent.getStringExtra(Constants.TOTAL_QUESTIONS)
        scoreTV?.text = "Your score is $score out of $total"

        finish?.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}