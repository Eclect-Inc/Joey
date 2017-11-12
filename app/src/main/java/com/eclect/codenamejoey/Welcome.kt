package com.eclect.codenamejoey

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import kotlinx.android.synthetic.main.activity_welcome.*
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan


class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeSimple)
        setContentView(R.layout.activity_welcome)

//        val prompt = SpannableStringBuilder()
//        prompt.append("Don't have an account?")
//        val start = prompt.length
//        prompt.append(" Sign up!")
//        val boldSpan = StyleSpan(android.graphics.Typeface.BOLD)
//        prompt.setSpan(StyleSpan(Typeface.BOLD),start, prompt.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
//
//
//
//
//        btnReg.setText(prompt)
    }


}