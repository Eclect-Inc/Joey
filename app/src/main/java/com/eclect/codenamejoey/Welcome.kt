package com.eclect.codenamejoey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.EditText
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import mehdi.sakout.fancybuttons.FancyButton


class Welcome : AppCompatActivity() {

    private val fbAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeSimple)
        setContentView(R.layout.activity_welcome)

        val btnLogin = findViewById<FancyButton>(R.id.btn_login)
        val fieldEmail  = findViewById<EditText>(R.id.editText)
        val fieldPassword = findViewById<EditText>(R.id.editText2)
        val btnRegistration = findViewById<FancyButton>(R.id.btnReg)

        btnRegistration.setOnClickListener {

            val intent = Registration.newIntent(this)
            startActivity(intent)

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

                //TODO: Usher in a NEW activity, the main activity. HOORAY!

                showMessage(view, "Logged In")

            }else {

                showMessage(view, "either your email or password is incorrect!")
            }

        } )
    }


    private fun showMessage(view: View, message: String){

        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).setAction("Action", null)
                .show()

    }

}