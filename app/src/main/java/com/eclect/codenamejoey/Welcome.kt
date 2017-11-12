package com.eclect.codenamejoey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*
import android.text.SpannableStringBuilder


class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeSimple)
        setContentView(R.layout.activity_welcome)

        val prompt = SpannableStringBuilder()
        prompt.append("Don't have an account?")

        btnReg.setText(prompt.toString())
    }


}