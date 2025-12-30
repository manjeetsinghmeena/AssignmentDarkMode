package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var isVerified = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etAge = findViewById<TextInputEditText>(R.id.etAge)
        val etNumber = findViewById<TextInputEditText>(R.id.etNumber)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val btnVerify = findViewById<Button>(R.id.btnVerify)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        fun resetVerification() {
            isVerified = false
            tvStatus.text = "Not Verified"
            tvStatus.setTextColor(
                resources.getColor(android.R.color.holo_red_dark)
            )
        }
        etName.addTextChangedListener { resetVerification() }
        etAge.addTextChangedListener { resetVerification() }
        etNumber.addTextChangedListener { resetVerification() }
        etMail.addTextChangedListener { resetVerification() }

        btnVerify.setOnClickListener {
            val name = etName.text.toString().trim()
            val ageText = etAge.text.toString().trim()
            val number = etNumber.text.toString().trim()
            val mail = etMail.text.toString().trim()

            if(name.isEmpty()){
                etName.error = "Name required"
                return@setOnClickListener
            }
            if(ageText.isEmpty()){
                etAge.error = "Age required"
                return@setOnClickListener
            }
            if (number.isEmpty()) {
                etNumber.error = "Number required"
                return@setOnClickListener
            }
            if (mail.isEmpty()) {
                etMail.error = "Mail required"
                return@setOnClickListener
            }
            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                etMail.error = "Enter valid mail"
                return@setOnClickListener
            }
            if(number.length!=10) {
                etNumber.error = "Enter valid number"
                return@setOnClickListener
            }

            val age = ageText.toInt()
            if(age<1 || age>120){
                etAge.error = "Enter valid age"
                return@setOnClickListener
            }
            isVerified = true
            tvStatus.text = "Verified"
            tvStatus.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        }
        val btnContinue = findViewById<Button>(R.id.btnContinue)
        btnContinue.setOnClickListener {
            if(!isVerified){
                tvStatus.text = "Please verify first"
                tvStatus.setTextColor(
                    resources.getColor(android.R.color.holo_red_dark)
                )
                return@setOnClickListener
            }
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("NAME", etName.text.toString().trim())
            intent.putExtra("AGE", etAge.text.toString().trim())
            intent.putExtra("NUMBER", etNumber.text.toString().trim())
            intent.putExtra("MAIL", etMail.text.toString().trim())
            startActivity(intent)
        }
    }
}