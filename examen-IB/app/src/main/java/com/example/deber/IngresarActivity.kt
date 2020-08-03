package com.example.deber

import android.content.Intent

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ingresar.*

class IngresarActivity : AppCompatActivity() {
    var usuario:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar)
        usuario = intent.getStringExtra("usuario").toString()
        btnAceptar.setOnClickListener { aceptarIngreso() }
        btnCancelar.setOnClickListener { cancelarIngreso()}
    }

    fun cancelarIngreso(){
        val intentCancelar= Intent(this, MenuActivity::class.java)
        intentCancelar.putExtra("usuario", usuario)
        startActivity(intentCancelar)
    }

    fun aceptarIngreso(){
        val equipo= Tienda(id = null,
            nombreTienda = txtNombre.text.toString(),
            direccionTienda = txtLiga.text.toString(),
            fechaCreacionTienda = txtFechaCreacion.text.toString(),
            valorTienda = txtNumCopInter.text.toString().toDouble(),
            familiar = txtCampeonActual.text.toString())
        BDEquipoFutbol.agregarEquipo(equipo)
        Toast.makeText(this, "Ingreso exitoso "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }
}
