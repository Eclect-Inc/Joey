package com.eclect.codenamejoey

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.*
import com.google.firebase.auth.FirebaseAuth
import mehdi.sakout.fancybuttons.FancyButton
import java.sql.Driver


class DriverRegistration : AppCompatActivity() {

    private val fbAuth = FirebaseAuth.getInstance()
    private lateinit var driverFirstName: EditText
    private lateinit var driverLastName: EditText
    private lateinit var driverEmail: EditText
    private lateinit var driverPassword: EditText
    private lateinit var driverPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeSimple)
        setContentView(R.layout.activity_driver_registration)

        driverFirstName = findViewById(R.id.fieldFirstName)
        driverLastName = findViewById(R.id.fieldLastName)
        driverEmail = findViewById(R.id.fieldEmail)
        driverPassword = findViewById(R.id.fieldPassword)
        driverPhone = findViewById(R.id.fieldPhoneNumber)

        val database = FirebaseDatabase.getInstance()
        val lunch = database.getReference("getref")
        val btnRegistration = findViewById<FancyButton>(R.id.btnRegister)

        btnRegistration.setOnClickListener {
            saveCredentials()
        }


    }

    private fun saveCredentials(){
        val firstName = driverFirstName.text.toString().trim()
        val lastName = driverLastName.text.toString().trim()
        val email = driverEmail.text.toString().trim()
        val password = driverPassword.text.toString()
        val phoneNumber = driverPhone.text.toString().trim()

        if (firstName.isEmpty()){
            driverFirstName.error = "Please enter your first name"
        }
        if (lastName.isEmpty()){
            driverLastName.error = "Please enter your last name"
            return
        }
        if (email.isEmpty()){
            driverEmail.error = "Please enter your email"
            return
        }
        if (password.isEmpty()){
            driverPassword.error = "Please enter a password"
            return
        }
        if (phoneNumber.isEmpty()){
            driverPhone.error = "Please your phone number"
            return
        }


        val userRef = FirebaseDatabase.getInstance().getReference("users")
        val driverRef = userRef.child("drivers")
        val genUserRef = userRef.child("basic_user")

        fbAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
            if (task.isSuccessful) {

                val user = fbAuth.currentUser
                val uid = user!!.uid
                val isDriver = "true"
                val driverUser = uDriver(uid, firstName, lastName, email, phoneNumber, isDriver)
                val person = Person(uid, firstName, lastName, email, isDriver)

                //shown in db
                driverRef.child(uid).setValue(driverUser).addOnCompleteListener {
                    Toast.makeText(applicationContext, "User created", Toast.LENGTH_LONG).show()
                }
                genUserRef.child(uid).setValue(person)

                startActivity(Intent(this, MainActivity::class.java))
                Toast.makeText(this, "Successfully registered :)", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Error registering, try again later :(", Toast.LENGTH_LONG).show()
            }
        })
    }

}