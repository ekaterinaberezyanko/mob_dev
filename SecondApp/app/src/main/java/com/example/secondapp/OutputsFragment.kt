package com.example.secondapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
const val TEXT_KEY = "TEXT"

class OutputsFragment :Fragment() {
    val displayText: String by lazy {
        arguments?.getString(TEXT_KEY) ?: ""
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_outputs, container, false)
        val displayInputsView = view.findViewById<TextView>(R.id.displayInputs)
        displayInputsView.text = displayText

        return view
    }
    companion object {
        fun newInstance(question: String, answer: String): OutputsFragment {
            val fragment = OutputsFragment()

            val composedText = composeText(question, answer)

            val args = Bundle()
            args.putString(TEXT_KEY, composedText)

            fragment.arguments = args

            return fragment
        }

        fun composeText(question: String, answer: String): String {
            return "$question\n$answer"
        }
    }
}