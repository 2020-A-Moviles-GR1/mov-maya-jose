package com.example.deber

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_actualizar.*

class ActualizarActivity : AppCompatActivity() {
    var padreId : Int = 0
    var usuario :String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar)
        usuario = intent.getStringExtra("usuario").toString()
        val tiendaRecibida = intent.getParcelableExtra<Tienda>("Equipo")
        txtNombre.setText(tiendaRecibida.nombreTienda.toString())
        txtLiga.setText(tiendaRecibida.direccionTienda.toString())
        txtFechaCreacion.setText(tiendaRecibida.fechaCreacionTienda.toString())
        txtNumCopInter.setText(tiendaRecibida.valorTienda.toString())
        txtCampeonAct.setText(tiendaRecibida.familiar.toString())
        padreId = tiendaRecibida.id!!;
        btnActualizar.setOnClickListener { actualizarTienda() }
        btnEliminar.setOnClickListener { eliminarTienda() }
        btnCrearJugador.setOnClickListener { crearCliente() }
        btnGestionarJugador.setOnClickListener { gestionarCliente() }
        btnMenuRetorno.setOnClickListener { retorno() }
    }

    fun actualizarTienda(){
        val actualizarEquipo = Tienda(id = padreId,
            nombreTienda = txtNombre.text.toString(),
            direccionTienda = txtLiga.text.toString(),
            fechaCreacionTienda = txtFechaCreacion.text.toString(),
            valorTienda = txtNumCopInter.text.toString().toDouble(),
            familiar = txtCampeonAct.text.toString()
        )
        BDEquipoFutbol.actualizarEquipo(actualizarEquipo)
        Toast.makeText(this, "Actualización exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun eliminarTienda(){
        BDEquipoFutbol.eliminarEquipo(padreId);
        Toast.makeText(this, "Eliminación exitosa "+usuario, Toast.LENGTH_SHORT).show()
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }

    fun crearCliente(){
        val equipoRespaldo = Tienda(id = padreId,
            nombreTienda = txtNombre.text.toString(),
            direccionTienda = txtLiga.text.toString(),
            fechaCreacionTienda = txtFechaCreacion.text.toString(),
            valorTienda = txtNumCopInter.text.toString().toDouble(),
            familiar = txtCampeonAct.text.toString()
        )
        val retorno = Intent(this, IngresarJugadorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun gestionarCliente(){
        val equipoRespaldo = Tienda(id = padreId,
            nombreTienda = txtNombre.text.toString(),
            direccionTienda = txtLiga.text.toString(),
            fechaCreacionTienda = txtFechaCreacion.text.toString(),
            valorTienda = txtNumCopInter.text.toString().toDouble(),
            familiar = txtCampeonAct.text.toString()

        )
        val retorno = Intent(this, ConsultarJugadorActivity::class.java)
        retorno.putExtra("usuario", usuario)
        retorno.putExtra("padreId", padreId)
        retorno.putExtra("EquipoRespaldo", equipoRespaldo)
        startActivity(retorno)
    }

    fun retorno(){
        val retorno = Intent(this, MenuActivity::class.java)
        retorno.putExtra("usuario", usuario)
        startActivity(retorno)
    }
}
