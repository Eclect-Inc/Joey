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
                .description("Lorem Ipsum...")
                .build())

        addSlide(SlideFragmentBuilder()
                .backgroundColor(R.color.colorPrimary)
                .buttonsColor(R.color.colorAccent)
                .image(R.drawable.joeyv3)
                .title("How to navigate...")
                .description("To navigate our interface you will have to...")
                .build())

    }

    override fun onFinish() {
        super.onFinish()
        val intent = Intent(this, Welcome::class.java)
        startActivity(intent)
    }

}