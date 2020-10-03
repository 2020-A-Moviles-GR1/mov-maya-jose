package com.example.examen_departamento_empleado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.beust.klaxon.Klaxon
import com.github.kittinunf.fuel.httpGet
import kotlinx.android.synthetic.main.activity_mostrar_departamento.*
import com.github.kittinunf.result.Result

class MostrarTienda : AppCompatActivity() {
    val urlPrincipal = "http://192.168.100.6:1337"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_departamento)
        Log.i("Activity","OnCreate")

        cargar()
        btn_mostrar.setOnClickListener{ boton ->
            mostrarLista()
        }
        TiendaHTTP.borrar()
        btn_cancelar_muestra_dep.setOnClickListener{ boton ->
            irOpncDepartamento()
        }
    }

    fun mostrarLista() {
        val adaptador = ArrayAdapter(
            this, //contexto
            android.R.layout.simple_expandable_list_item_1, // nomre layout
            TiendaHTTP.muestra()
        )//lista

        lv_departamento.adapter = adaptador
        lv_departamento
            .onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, position, id ->
            Log.i("list-view", "Posicion $position")
        }
    }

    fun cargar(){
        val url = urlPrincipal + "/Departamento"
        url
            .httpGet()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Success -> {
                        val data = result.get()
                        val departamento= Klaxon()
                            .converter(TiendaHTTP.converterUs).parseArray<TiendaHTTP>(data)
                        if (departamento != null) {
                            departamento.forEach {
                                Log.i(
                                    "http-klaxon",
                                    "${it}")
                                TiendaHTTP.guardar(it)

                                it.clientes?.forEach {
                                    Log.i(
                                        "http-klaxon",
                                        "${(it)}"
                                    )
                                    TiendaHTTP.guardar(it)
                                }
                            }
                        }
                    }

                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http-klaxon", "Error: ${ex.message}")
                        TiendaHTTP.guardar("${ex.message}")
                    }

                }
            }
    }

    fun irOpncDepartamento(){
        val intentExplicito= Intent(
            this, MenuTienda::class.java
        )
        this.startActivity(intentExplicito)
    }
}