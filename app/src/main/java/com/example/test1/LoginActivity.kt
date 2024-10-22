package com.example.test1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var storedUsername: String? = null
    private var storedPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle Sign-Up button click
        binding.signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, 1)
        }

        // Handle Login button click
        binding.loginButton.setOnClickListener {
            val enteredUsername = binding.username.text.toString()
            val enteredPassword = binding.password.text.toString()

            // Validate login credentials
            if (isValidLogin(enteredUsername, enteredPassword)) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                // You can now move to the next activity (MainActivity, for example)
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Capture result from SignUpActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            storedUsername = data?.getStringExtra(SignUpActivity.EXTRA_USERNAME)
            storedPassword = data?.getStringExtra(SignUpActivity.EXTRA_PASSWORD)

            // Add log statement to check stored credentials
            Log.d("LoginActivity", "Stored Username: $storedUsername, Stored Password: $storedPassword")

            Toast.makeText(this, "Sign Up Successful! You can now log in.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidLogin(username: String, password: String): Boolean {
        return username == storedUsername && password == storedPassword
    }
}
