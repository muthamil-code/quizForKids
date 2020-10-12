package com.tam.quizforkids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var getUserName = intent.getStringExtra(Constants.userName)
        tv_userName.text = getUserName
        var getAnswer = intent.getIntExtra(Constants.Correct_answers,0)
        var getQuestions = intent.getIntExtra(Constants.total_question,0)
        tv_finalResult.text = "your score is $getAnswer out of $getQuestions"

        button_finish.setOnClickListener { view ->

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}