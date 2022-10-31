package com.itmo.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class GameActivity : AppCompatActivity() {

    var score = 0
    var playerScore: TextView? = null
    var pressed : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_playground)
        playerScore = findViewById(R.id.scoreDisplay)
        playGame()
    }


    fun playGame() {
        if (score >= 10) {
            startActivity(Intent(this, WinActivity::class.java))
        } else {
            val image = pickImage()
            clickable(image).start()
        }
    }

    private fun pickImage(): ImageButton {
        val images = findViewById<ConstraintLayout>(R.id.playground).touchables
        images.shuffle()
        val randomImage = images[0] as ImageButton
        randomImage.setImageResource(R.drawable.mole)
        return randomImage
    }

    private fun clickable(image: ImageButton): CountDownTimer {
        image.setOnClickListener {
            if (!pressed){
                image.setImageResource(R.drawable.hit)
                score++
                playerScore?.text = score.toString()
                pressed = true
            }

        }

        return object : CountDownTimer(3000, 100) {

            override fun onTick(millisUntilFinished: Long) {
                if (pressed){
                    image.setImageResource(R.drawable.hit)
                }
            }

            override fun onFinish() {
                image.setImageResource(R.drawable.hole)
                image.setOnClickListener(null)
                pressed = false
                playGame()
            }

        }
    }
}

