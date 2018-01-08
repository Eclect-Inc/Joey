package com.eclect.codenamejoey

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText


class DriverRegistration : AppCompatActivity() {

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










    }
}