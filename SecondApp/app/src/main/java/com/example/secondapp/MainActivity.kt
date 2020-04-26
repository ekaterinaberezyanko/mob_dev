package com.example.secondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_inputs.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCheckValues(view: View) {
        val inputsFragment = supportFragmentManager.findFragmentById(R.id.inputsFragment) as InputsFragment
        val question = inputsFragment.getQuestion()

        if (question == "") {
            inputsFragment.showError()
        } else {
            inputsFragment.hideError()
            displayValues(question)
        }
    }

    private fun displayValues(question: String) {
        val inputsFragments = supportFragmentManager.findFragmentById(R.id.inputsFragment) as InputsFragment
        val answer = inputsFragments.getAnswer()
        var displayFragment = supportFragmentManager.findFragmentById(R.id.outputsFragment) as OutputsFragment
        if (OutputsFragment.composeText(question, answer) != displayFragment.displayText) {
            displayFragment = OutputsFragment.newInstance(question, answer)
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.outputsFragment, displayFragment)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }
    }
}