package com.eclect.codenamejoey

import agency.tango.materialintroscreen.MaterialIntroActivity
import android.os.Bundle
import agency.tango.materialintroscreen.MessageButtonBehaviour
import agency.tango.materialintroscreen.SlideFragmentBuilder
import android.view.View


class IntroActivity : MaterialIntroActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        addSlide(SlideFragmentBuilder()
                .backgroundColor(R.color.FF0FDD6B)
                .buttonsColor(R.color.FF0FDD6B)
                .image(R.drawable.joeyv3)
                .title("Why Joey")
                .description("It's like Roadie but better because we're Australian")
                .build(),
                MessageButtonBehaviour(View.OnClickListener { showMessage("Welcome") }, "Use Joey"))
    }

}
