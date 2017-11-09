package com.eclect.codenamejoey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class Splash : AppCompatActivity() {

    lateinit var timer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeSplash)
        setContentView(R.layout.activity_splash)
        val intent = Intent(this, MainActivity::class.java)

        //kotlin isn't HORRIBLE
       timer = object: CountDownTimer(3000, 1000) {

          override fun onTick(millisUntilFinished:Long) {

            }

           override fun onFinish() {
                startActivity(intent)
            }
        }.start()
    }

    // rip redundant semicolons


}
