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
                .image(R.drawable.joey)
                .title("Welcome to Codename Joey!")
                .description("Description")
                .build())

        addSlide(SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.joey)
                .title("Slide 2")
                .description("Description")
                .build())

        addSlide(SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.joey)
                .title("Slide 3")
                .description("Description")
                .build())

    }

    override fun onFinish() {
        super.onFinish()
        val intent = Intent(this, Welcome::class.java)
        startActivity(intent)
    }

}