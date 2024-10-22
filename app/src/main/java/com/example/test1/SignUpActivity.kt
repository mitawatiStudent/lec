package com.example.test1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test1.databinding.ActivitySignupBinding

class SignUpActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERNAME = "EXTRA_USERNAME"
        const val EXTRA_PASSWORD = "EXTRA_PASSWORD"
    }

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            val fullName = binding.registerFullName.text.toString()
            val email = binding.registerEmail.text.toString()
            val mobileNumber = binding.registerMobile.text.toString()
            val dob = binding.registerDob.text.toString()
            val password = binding.registerPassword.text.toString()
            val confirmPassword = binding.registerConfirmPassword.text.toString()

            if (password == confirmPassword) {
                if (fullName.isNotEmpty() && email.isNotEmpty() && mobileNumber.isNotEmpty() && dob.isNotEmpty()) {
                    val resultIntent = Intent().apply {
                        putExtra(EXTRA_USERNAME, email)
                        putExtra(EXTRA_PASSWORD, password)
                    }
                    setResult(RESULT_OK, resultIntent)
                    Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Please fill in all fields!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
