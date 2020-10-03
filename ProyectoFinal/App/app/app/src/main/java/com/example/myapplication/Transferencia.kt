package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Transferencia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transferencia)
        val btn_ok = findViewById<Button>(R.id.btn_ok)
        btn_ok.setOnClickListener {
            val intent = Intent (this, Fin::class.java )
            startActivity(intent)
        }


    }
}
