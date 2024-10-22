package com.example.test1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.test1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Display LoginFragment by default
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .commit()
        }
    }

    // Function to switch to SignUpFragment
    fun navigateToSignUp() {
        replaceFragment(SignUpFragment())
    }

    // Function to switch back to LoginFragment
    fun navigateToLogin() {
        supportFragmentManager.popBackStack() // Go back to previous fragment (LoginFragment)
    }

    // Helper function to replace fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null) // Add transaction to back stack so the user can navigate back
            .commit()
    }
}
