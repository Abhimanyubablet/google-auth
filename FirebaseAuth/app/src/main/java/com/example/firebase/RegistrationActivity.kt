package com.example.firebase

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegistrationActivity : AppCompatActivity() {
    private val userEmailInput: EditText? = null
    private  val userPassInput:EditText? = null
    private  val userRepeatPassInput:EditText? = null
    private val  signUpBtn: Button? = null
    lateinit var auth: FirebaseAuth



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        val  userEmailInput = findViewById<EditText>(R.id.user_email_input)
        val userPassInput = findViewById<EditText>(R.id.user_pass_input)
        val signUpBtn=findViewById<Button>(R.id.signup_btn)
        val signIn=findViewById<TextView>(R.id.text_sign_in)

        auth = Firebase.auth
        signUpBtn.setOnClickListener {
            auth.createUserWithEmailAndPassword(userEmailInput.text.toString() , userPassInput.text.toString())
                .addOnSuccessListener {
                    Toast.makeText(this, "successful", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
        }


    signIn.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }




    }


}


