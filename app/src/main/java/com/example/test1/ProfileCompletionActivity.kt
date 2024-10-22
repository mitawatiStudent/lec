package com.example.test1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileCompletionActivity : AppCompatActivity() {

    private lateinit var profileImageView: ImageView
    private lateinit var fullNameEditText: EditText
    private lateinit var genderEditText: EditText
    private lateinit var mobileNumberEditText: EditText
    private lateinit var dateOfBirthEditText: EditText
    private lateinit var continueButton: Button
    private lateinit var uploadImageButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_completion)

        // Initialize views
        profileImageView = findViewById(R.id.profileImage)
        fullNameEditText = findViewById(R.id.fullNameEditText)
        genderEditText = findViewById(R.id.genderEditText)
        mobileNumberEditText = findViewById(R.id.mobileNumberEditText)
        dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText)
        continueButton = findViewById(R.id.continueButton)
        uploadImageButton = findViewById(R.id.uploadImageButton)

        // Handle uploading the profile picture
        uploadImageButton.setOnClickListener {
            // Logic to upload profile picture (e.g., open camera or gallery)
            Toast.makeText(this, "Upload profile picture clicked!", Toast.LENGTH_SHORT).show()
        }

        // Handle the continue button click
        continueButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val gender = genderEditText.text.toString()
            val mobileNumber = mobileNumberEditText.text.toString()
            val dateOfBirth = dateOfBirthEditText.text.toString()

            if (fullName.isEmpty() || gender.isEmpty() || mobileNumber.isEmpty() || dateOfBirth.isEmpty()) {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
            } else {
                // Assuming the profile completion is successful, navigate to the next screen
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("EXTRA_FULL_NAME", fullName)
                startActivity(intent)
            }
        }
    }
}
