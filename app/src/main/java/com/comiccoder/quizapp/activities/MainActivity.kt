package com.comiccoder.quizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.comiccoder.quizapp.R
import com.comiccoder.quizapp.constants.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart : Button
    private lateinit var edtName : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnStart)
        edtName = findViewById(R.id.edtName)
        btnStart.setOnClickListener{
            if (edtName.text.isEmpty())
            {
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, edtName.text.toString().trim())
                startActivity(intent)
                finish()
            }
        }


    }
}