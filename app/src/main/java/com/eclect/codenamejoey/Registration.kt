package com.eclect.codenamejoey

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
    }


    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context,  Registration::class.java)
            return intent
        }
    }

}
