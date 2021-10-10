package com.example.planetquiz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

interface AnswerListener{
    fun onSelected(questionId: Int)
}
class QuestionFragment : Fragment(), View.OnClickListener {

  private lateinit var answerListener: AnswerListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is AnswerListener){
            answerListener= context
        }
        else{
            throw RuntimeException("must impliment answerListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planets = listOf<View>(
            view.findViewById(R.id.most_moons),
            view.findViewById(R.id.largest_planet),
             view.findViewById(R.id.spins_side)
        )
        planets.forEach{
            it.setOnClickListener(this)
        }
    }

   override fun onClick(v: View?){
       v?.let { questionId ->
           answerListener.onSelected(questionId.id)

       }
   }

}