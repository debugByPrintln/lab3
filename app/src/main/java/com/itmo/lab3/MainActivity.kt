package com.itmo.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_start)

        findViewById<Button>(R.id.startButton).setOnClickListener { startGame() }

        findViewById<Button>(R.id.nextButton).setOnClickListener { clickNext() }

        findViewById<TextView>(R.id.winners).text = Logic.getWinnersList()
    }

    private fun clickNext(){
        val name = findViewById<EditText>(R.id.editText).text.toString().trim()
        Logic.addNewWinner(name)
        if (isValidName(name)){
            beginGame()
        }
        else{
            val toast = Toast.makeText(applicationContext, "Enter a valid name (from 3 to 12 symbols)", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    private fun beginGame(){
        startActivity(Intent(this, GameActivity::class.java))
    }

    private fun startGame(){
        findViewById<Button>(R.id.startButton).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.label).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.winners).visibility = View.INVISIBLE

        findViewById<Button>(R.id.nextButton).visibility = View.VISIBLE
        findViewById<EditText>(R.id.editText).visibility = View.VISIBLE
    }

    private fun isValidName(name:String): Boolean {
        if (name.length !in 3..13){
            return false
        }
        return true
    }
}