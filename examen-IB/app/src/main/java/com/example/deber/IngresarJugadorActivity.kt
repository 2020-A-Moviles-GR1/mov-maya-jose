package com.example.deber

import android.content.Intent

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ingresar_jugador.*

class IngresarJugadorActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    var equipoRespaldo : Tienda? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_jugador)
        usuario = intent.getStringExtra("usuario").toString()
        equipoRespaldo = intent.getParcelableExtra<Tienda>("EquipoRespaldo")
        padreId = intent.getIntExtra("padreId", -1)
        btnGuardar.setOnClickListener { guardarJugador() }
    }

    fun guardarJugador(){
        val jugador = Cliente(id = null,
            numeroTelefonoCliente = txtnumeroCamiseta.text.toString().toInt(),
            nombreCliente = txtNombreCamiseta.text.toString(),
            nombreCompletoCliente = txtNombreJugador.text.toString(),
            direccionCliente = txtpoderEspecialDos.text.toString(),
            fechaNacimientoCliente = txtfechaIngresoEquipo.text.toString(),
            edad = txtGoles.text.toString().toInt(),
            equipoFutbolId = padreId)
        BDJugador.agregarJugador(jugador)
        Toast.makeText(this, "Jugador creado exitosamente "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }
}
