package com.eclect.codenamejoey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Switch
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_welcome.*
import mehdi.sakout.fancybuttons.FancyButton
import kotlin.math.sign


class Welcome : AppCompatActivity() {

    private val fbAuth = FirebaseAuth.getInstance()
    private var debugUser: Boolean?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeSimple)
        setContentView(R.layout.activity_welcome)


        val switchUser = findViewById<Switch>(R.id.switch1)
        val btnLogin = findViewById<FancyButton>(R.id.btn_login)
        val fieldEmail  = findViewById<EditText>(R.id.editText)
        val fieldPassword = findViewById<EditText>(R.id.editText2)
        val btnRegistration = findViewById<FancyButton>(R.id.btnReg)

        btnRegistration.setOnClickListener {
            val regIntent = Intent(this, Registration::class.java)
            startActivity(regIntent)
        }
        fun driverLogin(){
            imageView2.setOnClickListener{ view ->
                signIn(view, "ms@user", "pass123")

            }
        }
        fun basicUserLogin(){
            imageView2.setOnClickListener{ view ->
                signIn(view, "mr@driver.xyz", "pass123")

            }

        }
        //isChecked
        switchUser.setOnCheckedChangeListener { _, _ -> run {
            if (debugUser == false) {
                debugUser = true
                Log.d("debugBuddy", "Logging in as Driver")
                val driverText: String = "Driver"
                switchUser.setText(driverText)
                driverLogin()
            } else {
                debugUser = false
                Log.d("debugBuddy", "Logging in as General User")
                val basicUserText: String = "General User"
                switchUser.setText(basicUserText)
                basicUserLogin()
            }
        }

        }



        btnLogin.setOnClickListener { view ->

            val email = fieldEmail.text.toString()
            val password = fieldPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                showMessage(view, "Please enter both your email and password!")
            } else {
                signIn(view, email, password)
            }
        }
    }

    private fun signIn(view: View, email: String, password: String){

        fbAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this,
                OnCompleteListener<AuthResult> { task ->
            if (task.isSuccessful){
                showMessage(view, "Logged In")
                val Mainintent = Intent(this, MainActivity::class.java)
                startActivity(Mainintent)
            }else {

                showMessage(view, "Email or password is incorrect!")
            }

        } )

    }

    private fun showMessage(view: View, message: String){

        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).setAction("Action", null)
                .show()

    }

}