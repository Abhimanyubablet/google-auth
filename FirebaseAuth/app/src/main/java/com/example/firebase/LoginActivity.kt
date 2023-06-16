package com.example.firebase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.firebase.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val  userEmailInput = findViewById<EditText>(R.id.login_email)
        val userPassInput = findViewById<EditText>(R.id.login_pass)
        val LogBtn=findViewById<Button>(R.id.log_btn)
        val signUp=findViewById<TextView>(R.id.text_signup)

        auth = Firebase.auth
        LogBtn.setOnClickListener {
            auth.signInWithEmailAndPassword(userEmailInput.text.toString() , userPassInput.text.toString())
                .addOnSuccessListener {
                    Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
        }


        signUp.setOnClickListener {
            startActivity(Intent(this,RegistrationActivity::class.java))
        }
        }
    }

