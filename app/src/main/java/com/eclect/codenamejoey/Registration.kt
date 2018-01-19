package com.eclect.codenamejoey

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.*
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_registration.*
import mehdi.sakout.fancybuttons.FancyButton
import com.google.firebase.auth.FirebaseAuth
import com.hypertrack.lib.HyperTrack
import com.hypertrack.lib.models.SuccessResponse
import com.hypertrack.lib.models.UserParams
import android.R.attr.phoneNumber
import android.R.attr.name
import android.graphics.BitmapFactory
import android.media.Image
import android.view.View
import android.R.attr.bitmap
import android.graphics.Bitmap
import android.widget.ImageView
import com.hypertrack.lib.callbacks.HyperTrackCallback


class Registration : AppCompatActivity() {

    private val fbAuth = FirebaseAuth.getInstance()
    private lateinit var userFirstName: EditText
    private lateinit var userLastName: EditText
    private lateinit var userEmail: EditText
    private lateinit var userPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeSimple)
        setContentView(R.layout.activity_registration)

        userFirstName = findViewById(R.id.etFirstName)
        userLastName= findViewById(R.id.etLastName)
        userEmail = findViewById(R.id.etEmail)
        userPassword = findViewById(R.id.etPassword)


        val btnDriver = findViewById<FancyButton>(R.id.btnDriverReg)

        btnDriver.setOnClickListener {
            startActivity(Intent(this, DriverRegistration::class.java))
        }

        val btnRegistration = findViewById<FancyButton>(R.id.btnRegister)

        btnRegistration.setOnClickListener {
                saveCredentials()
        }


    }
    //@SuppressLint("ShowToast")



    @SuppressLint("ShowToast")
    private fun saveCredentials(){
        val firstName = etFirstName.text.toString().trim()
        val lastName = etLastName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()

        if (firstName.isEmpty()){
            etFirstName.error = "Please enter your first name"
            return

        }
        if (lastName.isEmpty()){
            etLastName.error = "Please enter your last name"
            return
        }
        if (email.isEmpty()){
            etEmail.error = "Please enter your email"
            return
        }
        if (password.isEmpty()){
            etPassword.error = "Please enter a password"
            return
        }

        //TODO: Export Signup to a class and plugit it in both Registration and DriverRegistration

        val name:String =  firstName + " " + lastName

        val userRef = FirebaseDatabase.getInstance().getReference("users")
        val genUserRef = userRef.child("basic_user")




        fbAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = fbAuth.currentUser
                val uid = user!!.uid
                val isDriver = "false"
                val person = Person(uid, firstName, lastName, email, isDriver)
                val photo =  "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"

                //shown in db
                genUserRef.child(uid).setValue(person).addOnCompleteListener {
                    Toast.makeText(applicationContext, "User created", Toast.LENGTH_LONG)
                }





                startActivity(Intent(this, Gate::class.java))
                Toast.makeText(this, "Successfully registered :)", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Error registering, try again later :(", Toast.LENGTH_LONG).show()
            }
        })
    }
    }







//    companion object {
//        fun newIntent(context: Context): Intent {
//            val intent = Intent(context,  Registration::class.java)
//            return intent
//
//        }
//    }


