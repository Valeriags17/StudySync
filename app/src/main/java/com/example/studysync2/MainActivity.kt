package com.example.studysync2

import android.content.Intent
import android.os.Bundle
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
                // If login is successful, navigate to MainActivity2
                navigateToMainActivity2()
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

    private fun navigateToMainActivity2() {
        // Replace MainActivity2::class.java with the actual class of MainActivity2
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}
