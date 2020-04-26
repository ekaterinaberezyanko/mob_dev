package com.example.secondapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class InputsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inputs, container, false)
    }

    fun getAnswer(): String {
        val answerGroup = view?.findViewById<RadioGroup>(R.id.answerGroup)
        val answerButton = view?.findViewById<RadioButton>(answerGroup!!.checkedRadioButtonId)

        return answerButton?.text.toString()
    }

    fun getQuestion(): String {
        val questionInput = view?.findViewById<EditText>(R.id.questionInput)

        return questionInput?.text.toString()
    }
    fun showError() {
        val errorLabel = view?.findViewById<TextView>(R.id.errorMessage)
        errorLabel?.visibility = View.VISIBLE
    }

    fun hideError() {
        val errorLabel = view?.findViewById<TextView>(R.id.errorMessage)
        errorLabel?.visibility = View.GONE
    }

}