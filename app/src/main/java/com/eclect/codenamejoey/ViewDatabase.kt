package com.eclect.codenamejoey

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

/**
 * Created by shawdotion on 12/8/17.
 */
class ViewDatabase : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeSimple)
        setContentView(R.layout.activity_main)
        val database= FirebaseDatabase.getInstance()



    }
}
