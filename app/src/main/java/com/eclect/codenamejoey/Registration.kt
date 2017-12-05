package com.eclect.codenamejoey

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_registration.*
import mehdi.sakout.fancybuttons.FancyButton


class Registration : AppCompatActivity() {

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

        val database = FirebaseDatabase.getInstance()
        //ref
        val lunch = database.getReference("uM")
        lunch.setValue("Values being set:")

        val btnRegistration = findViewById<FancyButton>(R.id.btnRegister)


        btnRegistration.setOnClickListener {
                saveCredentials()
        }

    }
    //@SuppressLint("ShowToast")
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



        val lunch = FirebaseDatabase.getInstance().getReference("persons")

        val personID = lunch.push().key

        val person= Person(personID, firstName, lastName, email, password)

        lunch.child(personID).setValue(person).addOnCompleteListener {
            Toast.makeText(applicationContext, "User created", Toast.LENGTH_LONG)
        }


    }


//    companion object {
//        fun newIntent(context: Context): Intent {
//            val intent = Intent(context,  Registration::class.java)
//            return intent
//
//        }
//    }

}
