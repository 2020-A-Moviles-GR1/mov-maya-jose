package com.example.deber

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_actualizar_jugador.*

class ActualizarJugadorActivity : AppCompatActivity() {
    var id :Int = 0;
    var idPadre :Int = 0
    var usuario :String = "";
    var equipoRespaldo : Tienda? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_jugador)
        usuario = intent.getStringExtra("usuario").toString()
        val clienteRecibido = intent.getParcelableExtra<Cliente>("Jugador")
        equipoRespaldo = intent.getParcelableExtra<Tienda>("EquipoRespaldo")
        txtnumeroCamiseta.setText(clienteRecibido.numeroTelefonoCliente.toString())
        txtNombreCamiseta.setText(clienteRecibido.nombreCliente.toString())
        txtNombreJugador.setText(clienteRecibido.nombreCompletoCliente.toString())
        txtpoderEspecialDos.setText(clienteRecibido.direccionCliente.toString())
        txtfechaIngresoEquipo.setText(clienteRecibido.fechaNacimientoCliente.toString())
        txtGoles.setText(clienteRecibido.edad.toString())
        id = clienteRecibido.id.toString().toInt()
        idPadre = clienteRecibido.equipoFutbolId.toString().toInt()
        btnActualizarJugador.setOnClickListener { actualizarJugador() }
        btnEliminarJugador.setOnClickListener { eliminarJugador() }
    }

    fun actualizarJugador(){
        val jugador = Cliente(id = id,
            numeroTelefonoCliente = txtnumeroCamiseta.text.toString().toInt(),
            nombreCliente = txtNombreCamiseta.text.toString(),
            nombreCompletoCliente = txtNombreJugador.text.toString(),
            direccionCliente = txtpoderEspecialDos.text.toString(),
            fechaNacimientoCliente = txtfechaIngresoEquipo.text.toString(),
            edad = txtGoles.text.toString().toInt(),
            equipoFutbolId = idPadre)
        BDJugador.actualizarJugador(jugador)
        Toast.makeText(this, "Actualización jugador exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }

    fun eliminarJugador(){
        BDJugador.eliminarJugador(id)
        Toast.makeText(this, "Eliminación jugador exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, ActualizarActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("Equipo", equipoRespaldo)
        startActivity(retorno)
    }
}
