package com.example.quizapp.activities

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.constants.Constants
import com.example.quizapp.dataModel.Question
import java.util.Timer

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var currentPosition = 1
    private var questionsList: ArrayList<Question>? = null
    private var selectedOptionPosition = 0
    private var score = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var submitBtn: Button? = null
    private val options = ArrayList<TextView>()
    var clicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.imgVw)
        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        submitBtn = findViewById(R.id.submitBtn)

        tvOptionOne?.let { options.add(0, it) }
        tvOptionTwo?.let { options.add(1, it) }
        tvOptionThree?.let { options.add(2, it) }
        tvOptionFour?.let { options.add(3, it) }

        questionsList = Constants.getQuestions()
        progressBar?.max = questionsList!!.size
        setQuestion()

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)

    }

    private fun setQuestion() {
        val currObject = questionsList!![currentPosition - 1]
        selectedOptionPosition = -1
        tvQuestion?.text = currObject.question
        ivImage?.setImageResource(currObject.image)
        progressBar?.progress = currentPosition
        tvProgress?.text = "${currentPosition}/${questionsList!!.size}"
        tvOptionOne?.text = currObject.optionOne
        tvOptionTwo?.text = currObject.optionTwo
        tvOptionThree?.text = currObject.optionThree
        tvOptionFour?.text = currObject.optionFour
        defaultOptionsView()
    }

    private fun defaultOptionsView() {
        for (option in options) {
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
        if (currentPosition == questionsList?.size) {
            submitBtn?.text = "FINISH"
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

        selectedOptionPosition = selectedOptionNum
    }

    override fun onClick(view: View?) {
        if (clicked) {
            return
        }
        when (view?.id) {
            R.id.tvOptionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 0)
                }
            }

            R.id.tvOptionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tvOptionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tvOptionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.submitBtn -> {
                clicked = true
                submitBtn?.let {
                    val correctAnswer = questionsList?.get(currentPosition - 1)!!.correctAnswer
                    if(selectedOptionPosition == correctAnswer)
                    {
                        score++
                    }
                    else
                    {
                        answerView(selectedOptionPosition, R.drawable.wrong_option_border)
                    }
                    answerView(correctAnswer, R.drawable.correct_option_border)
                    Handler().postDelayed({
                        // do something after 1000ms
                        if (currentPosition < questionsList!!.size) {
                            currentPosition++
                            clicked = false
                            setQuestion()
                        } else {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, getIntent().getStringExtra(Constants.USER_NAME))
                            intent.putExtra(Constants.SCORE, score.toString())
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList?.size.toString())
                            startActivity(intent)
                            finish()
                        }
                    }, 2000)
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            0 -> {
                tvOptionOne?.setTextColor(Color.parseColor("#000000"))
                tvOptionOne?.setTypeface(tvOptionOne?.typeface, Typeface.BOLD)
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            1 -> {
                tvOptionTwo?.setTextColor(Color.parseColor("#000000"))
                tvOptionTwo?.setTypeface(tvOptionTwo?.typeface, Typeface.BOLD)
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            2 -> {
                tvOptionThree?.setTextColor(Color.parseColor("#000000"))
                tvOptionThree?.setTypeface(tvOptionThree?.typeface, Typeface.BOLD)
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            3 -> {
                tvOptionFour?.setTextColor(Color.parseColor("#000000"))
                tvOptionFour?.setTypeface(tvOptionFour?.typeface, Typeface.BOLD)
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

}