package com.tam.quizforkids

object Constants{

    const val userName : String = "name"
    const val  total_question : String = "total_question"
    const val  Correct_answers : String = "correctAnswer"


    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        //1
        val ques1 = Question(1,"what animal does this image belongs too",
             R.drawable.dog,
            "dog",
            "lion",
            "monkey",
            "horse",
            1
        )
        questionList.add(ques1)
        //2
        val ques2 = Question(2,"what animal does this image belongs too",
            R.drawable.bears,
            "rabbit",
            "tiger",
            "monkey",
            "bear",
            4
        )
        questionList.add(ques2)
        //3
        val ques3 = Question(3,"what animal does this image belongs too",
            R.drawable.crocodiles,
            "dolphins",
            "crocodile",
            "dog",
            "lion",
            2
        )
        questionList.add(ques3)
        //4
        val ques4 = Question(4,"what animal does this image belongs too",
            R.drawable.dolphins,
            "dolphins",
            "crocodile",
            "dog",
            "lion",
            1
        )
        questionList.add(ques4)
        //5
        val ques5 = Question(5,"what animal does this image belongs too",
            R.drawable.horse,
            "dog",
            "horse",
            "lion",
            "monkey",
            2
        )
        questionList.add(ques5)
        //6
        val ques6 = Question(6,"what animal does this image belongs too",
            R.drawable.kangaroos,
            "dolphins",
            "crocodile",
            "dog",
            "kangaro",
            4
        )
        questionList.add(ques6)
        //7
        val ques7 = Question(7,"what animal does this image belongs too",
            R.drawable.lion,
            "lion",
            "crocodile",
            "dog",
            "lion",
            1
        )
        questionList.add(ques7)
        //8
        val ques8 = Question(8,"what animal does this image belongs too",
            R.drawable.monkey,
            "dolphins",
            "monkey",
            "dog",
            "lion",
            2
        )
        questionList.add(ques8)
        //9
        val ques9 = Question(9,"what animal does this image belongs too",
            R.drawable.rabbit,
            "dolphins",
            "crocodile",
            "dog",
            "rabbit",
            4
        )
        questionList.add(ques9)
        val ques10 = Question(10,"what animal does this image belongs too",
            R.drawable.tiger,
            "dolphins",
            "crocodile",
            "dog",
            "tiger",
            4
        )
        questionList.add(ques10)
        return questionList

    }
}