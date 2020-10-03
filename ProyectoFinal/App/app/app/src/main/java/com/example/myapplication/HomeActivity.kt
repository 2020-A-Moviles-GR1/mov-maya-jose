package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home2.*


class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

        auth = FirebaseAuth.getInstance()

        btn_registrar.setOnClickListener {
            signUpUser()

        }
    }

    private fun signUpUser() {
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

        auth.createUserWithEmailAndPassword(email_text_a.text.toString(), password_text_a.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                            }
                        }
                } else {
                    Toast.makeText(
                        baseContext, "Sign Up failed. Try again after some time.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}
