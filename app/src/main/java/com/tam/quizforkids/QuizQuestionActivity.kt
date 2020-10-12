package com.tam.quizforkids

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener{

    var mCurrentPosition : Int = 1
    var mQuestionListed : ArrayList<Question>? = null
    var mSelectedOption : Int = 0
    var mCorrectAnswer : Int = 0
    var mUserName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUserName = intent.getStringExtra(Constants.userName)

        mQuestionListed= Constants.getQuestions()
        Log.i("question size","${mQuestionListed!!.size}")
        setQuestion()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        button_submit.setOnClickListener(this)
    }
    private fun setQuestion(){

        var question = mQuestionListed!![mCurrentPosition - 1]

        defaultOption()
        if(mCurrentPosition == mQuestionListed!!.size){
            button_submit.text = "Finish"
        }else{
            button_submit.text = "Submit"
        }

        progressBar_id.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/"+ progressBar_id.max

        question_id.text = question!!.question
        image_id.setImageResource(question!!.image)
        tv_option_one.text = question!!.optionOne
        tv_option_two.text = question!!.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour
    }

    private fun defaultOption(){
        var options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){

            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_background_option_border_bg)


        }
    }

    override fun onClick(v: View?) {
             when(v?.id){
            R.id.tv_option_one ->{
               selectedOptionView(tv_option_one,1)
            }R.id.tv_option_two ->{
                 selectedOptionView(tv_option_two,2)
             }R.id.tv_option_three ->{
                     selectedOptionView(tv_option_three,3)
             }R.id.tv_option_four ->{
                     selectedOptionView(tv_option_four,4)
             }R.id.button_submit ->{
                          if(mSelectedOption == 0){
                              mCurrentPosition ++
                              Log.i("hi",mCurrentPosition.toString())

                              when{
                                  mCurrentPosition <= mQuestionListed!!.size -> {
                                      setQuestion()
                                  }else ->{
                                 val intent = Intent(this,ResultActivity::class.java)
                                  intent.putExtra(Constants.userName,mUserName)
                                  intent.putExtra(Constants.Correct_answers,mCorrectAnswer)
                                  intent.putExtra(Constants.total_question,mQuestionListed!!.size)
                                  startActivity(intent)
                              }

                              }
                              }else {
                              var question = mQuestionListed!![mCurrentPosition - 1]
                              if(question!!.answer != mSelectedOption){
                                  answerView(mSelectedOption,R.drawable.wrong_background_option_border_bg)
                              }else{
                                  mCorrectAnswer++
                              }
                              answerView(question.answer,R.drawable.correct_background_option_border_bg)

                              if(mCurrentPosition == mQuestionListed!!.size){
                                  button_submit.text = "FINISH"
                              }else{
                                  button_submit.text = "GO TO NEXT QUESTION"
                              }
                              mSelectedOption = 0

                          }

             }
        }
    }

    private fun answerView(answer : Int, drawableView : Int){

                        when(answer){
                            1->{
                                tv_option_one.background = ContextCompat.getDrawable(this,drawableView)
                            }
                            2->{
                                tv_option_two.background = ContextCompat.getDrawable(this,drawableView)
                            }
                            3->{
                                tv_option_three.background = ContextCompat.getDrawable(this,drawableView)
                            }
                            4->{
                                tv_option_four.background = ContextCompat.getDrawable(this,drawableView)
                            }

                        }

    }

    private fun selectedOptionView(tv : TextView,selectedOptionNum : Int){
        defaultOption()
        mSelectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_background_option_border_bg)
    }
}