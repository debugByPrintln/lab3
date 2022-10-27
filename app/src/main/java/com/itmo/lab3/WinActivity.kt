package com.itmo.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class WinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_win)
        restartGame().start()
    }

    private fun restartGame(): CountDownTimer {
        return object : CountDownTimer(5000, 100) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                startActivity(Intent(this@WinActivity, MainActivity::class.java))
            }
        }
    }
}