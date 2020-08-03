package com.example.deber

import android.content.Intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.deber.ConsultarActivity
import com.example.deber.IngresarActivity
import com.example.deber.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        usuario = intent.getStringExtra("usuario").toString()
        btnEquipo.setOnClickListener {gestionarEquipo() }
        btnCrearEquipo.setOnClickListener{ crearEquipo()}
    }

    fun gestionarEquipo(){
        val intentGestionarEquipo = Intent(this, ConsultarActivity::class.java)
        intentGestionarEquipo.putExtra("usuario", usuario)
        startActivity(intentGestionarEquipo)
    }

    fun crearEquipo(){
        val intentCrearEquipo = Intent(this, IngresarActivity::class.java)
        intentCrearEquipo.putExtra("usuario", usuario)
        startActivity(intentCrearEquipo)
    }
}
