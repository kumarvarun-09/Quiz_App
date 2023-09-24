package com.example.quizapp.constants

import com.example.quizapp.R
import com.example.quizapp.dataModel.Question

object Constants {
    const val USER_NAME = "userName"
    const val SCORE = "score"
    const val TOTAL_QUESTIONS = "total"
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        questionsList.add(Question(
            1, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 0
        ))

        questionsList.add(Question(
            2, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 2
        ))

        questionsList.add(Question(
            3, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 3
        ))

        questionsList.add(Question(
            4, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 1
        ))

        questionsList.add(Question(
            5, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 2
        ))

        questionsList.add(Question(
            6, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 0
        ))

        questionsList.add(Question(
            7, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 2
        ))

        questionsList.add(Question(
            8, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 3
        ))

        questionsList.add(Question(
            9, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 1
        ))

        questionsList.add(Question(
            10, "Which Country's Flag is this?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 0
        ))

        return questionsList
    }
}