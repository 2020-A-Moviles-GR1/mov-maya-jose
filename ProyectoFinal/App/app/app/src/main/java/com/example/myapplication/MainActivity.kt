package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btn_registrar


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        btn_registrar.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        btn_acceder.setOnClickListener {
            doLogin()
        }




    }

    private fun doLogin() {
        if (email_text_a.text.toString().isEmpty()) {
            email_text_a.error = "Please enter email"
            email_text_a.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email_text_a.text.toString()).matches()) {
            email_text_a.error = "Please enter valid email"
            email_text_a.requestFocus()
            return
        }

        if (password_text_a.text.toString().isEmpty()) {
            password_text_a.error = "Please enter password"
            password_text_a.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(
            email_text_a.text.toString(),
            password_text_a.text.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        updateUI(user)
                    } else {

                        updateUI(null)
                    }
                }
            }


    }


        public override fun onStart() {
            super.onStart()
            val currentUser = auth.currentUser
            updateUI(currentUser)
        }

        private fun updateUI(currentUser: FirebaseUser?) {

            if (currentUser != null) {
                if(currentUser.isEmailVerified) {
                    startActivity(Intent(this, Home::class.java))
                    finish()
                }else{
                    Toast.makeText(
                        baseContext, "Please verify your email address.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    baseContext, "Login failed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
}
