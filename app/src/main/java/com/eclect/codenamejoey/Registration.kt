package com.eclect.codenamejoey

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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



        val lunch = FirebaseDatabase.getInstance().getReference("persons")

        val personID = lunch.push().key



        fbAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = fbAuth.currentUser
                val uid = user!!.uid
                val person = Person(uid, firstName, lastName, email)

                //shown in db
                lunch.child(uid).setValue(person).addOnCompleteListener {
                    Toast.makeText(applicationContext, "User created", Toast.LENGTH_LONG)
                }
                startActivity(Intent(this, MainActivity::class.java))
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


