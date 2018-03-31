package com.eclect.codenamejoey

import agency.tango.materialintroscreen.MaterialIntroActivity
import agency.tango.materialintroscreen.SlideFragmentBuilder;

import android.content.Intent
import android.os.Bundle
import android.content.SharedPreferences

class Intro : MaterialIntroActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme(R.style.AppThemeSimple)
        //enableLastSlideAlphaExitTransition(true)
        addSlide(SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.joeyv3)
                .title("Welcome to Joey!")
                .description("Glad you could join us!")
                .build())

        addSlide(SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.joeyv3)
                .title("Our Mission")
                .description("Our mission is to be an uber for courier-based solutions.")
                .build())

        addSlide(SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.joeyv3)
                .title("To begin press the next button")
                .description("")
                .build())

    }

    override fun onFinish() {
        super.onFinish()
        val intent = Intent(this, Welcome::class.java)
        startActivity(intent)
    }

}