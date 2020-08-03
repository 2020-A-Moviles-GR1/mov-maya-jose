package com.example.deber

import android.content.Intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEntrar.setOnClickListener { ingresarUsuario() }
    }

    fun ingresarUsuario(){
        BDEquipoFutbol.guardarUsuario(txtNombre.text.toString())
        val intentMenu = Intent(this, MenuActivity::class.java)
        intentMenu.putExtra("usuario", txtNombre.text.toString())
        startActivity(intentMenu)
    }
}
