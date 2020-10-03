package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Factura : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura)

        val btn_home = findViewById<ImageButton>(R.id.btn_home)
        btn_home.setOnClickListener {
            val intent = Intent (this, Home::class.java )
            startActivity(intent)
        }

        val btn_ok = findViewById<Button>(R.id.btn_ok)
        btn_ok.setOnClickListener {
            val intent = Intent (this, MetodoPago::class.java )
            startActivity(intent)
        }


    }


}
