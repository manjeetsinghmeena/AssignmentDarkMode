package com.example.assignment

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvNumber = findViewById<TextView>(R.id.tvNumber)
        val tvMail = findViewById<TextView>(R.id.tvMail)


        val name = intent.getStringExtra("NAME")
        val age = intent.getStringExtra("AGE")
        val number = intent.getStringExtra("NUMBER")
        val mail = intent.getStringExtra("MAIL")

        tvName.text = "Name: $name"
        tvAge.text = "Age: $age"
        tvNumber.text = "Phone Number: $number"
        tvMail.text = "EMail: $mail"

    }
}