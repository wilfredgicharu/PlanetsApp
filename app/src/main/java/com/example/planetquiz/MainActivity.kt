package com.example.planetquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), AnswerListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if( savedInstanceState== null){
            findViewById<FragmentContainerView>(R.id.fragment_container)?.let { frameLayout ->
            val questionsFragment= QuestionFragment()

            supportFragmentManager.beginTransaction()
                .add(frameLayout.id, questionsFragment).commit()

            }
        }
    }

    override fun onSelected(questionId: Int) {
        findViewById<FragmentContainerView>(R.id.fragment_container)?.let {  frameLayout->
            val answerFragment= AnswerFragment.newInstance(questionId)

            supportFragmentManager.beginTransaction()
                .replace(frameLayout.id, answerFragment)
                .addToBackStack(null)
                .commit()

        }
    }
}