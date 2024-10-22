package com.example.test1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.test1.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private var storedUsername: String? = null
    private var storedPassword: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle login button click
        binding.loginButton.setOnClickListener {
            val enteredUsername = binding.username.text.toString()
            val enteredPassword = binding.password.text.toString()

            if (isValidLogin(enteredUsername, enteredPassword)) {
                Toast.makeText(requireContext(), "Login Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        // Handle sign-up text click
        binding.signUpText.setOnClickListener {
            (activity as MainActivity).navigateToSignUp() // Switch to SignUpFragment
        }
    }

    private fun isValidLogin(username: String, password: String): Boolean {
        // Replace this with actual login logic
        return username == storedUsername && password == storedPassword
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
