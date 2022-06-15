package com.example.lugares

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.lugares.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.login.setOnClickListener {
            login()
        }

        binding.register.setOnClickListener {
            register()
        }
    }

    private fun update(user: FirebaseUser?) {
        if (user != null){
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }

    public override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        update(user)
    }

    private fun login() {
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful){
                Log.d("User Login", "Success")
                val user = auth.currentUser
                Log.d("User", user.toString())
                update(user)
            } else {
                Log.d("User Login", "Fail")
                Toast.makeText(baseContext,"Fail", Toast.LENGTH_LONG).show()
                update(null)
            }
        }
    }

    private fun register() {
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful){
                Log.d("User Register", "Success")
                val user = auth.currentUser
                Log.d("User", user.toString())
                update(user)
            } else {
                Log.d("User Register", "Fail")
                Toast.makeText(baseContext,"Fail", Toast.LENGTH_LONG).show()
                update(null)
            }
        }
    }
}