package com.example.studysync2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val enteredUsername = username.text.toString()
            val enteredPassword = password.text.toString()

            if (isValidLogin(enteredUsername, enteredPassword)) {
                showToast("Login Successful!")
            } else {
                showToast("Login Failed!")
            }
        }
    }

    private fun isValidLogin(username: String, password: String): Boolean {
        return username == "user" && password == "1234"
    }

    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}


