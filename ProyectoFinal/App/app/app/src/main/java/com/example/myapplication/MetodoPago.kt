package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MetodoPago : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodo_pago)


        val btn_deposito = findViewById<Button>(R.id.btn_Deposito)
        btn_deposito.setOnClickListener {
            val intent = Intent (this, Deposito::class.java )
            startActivity(intent)
        }


        val btn_transferencia = findViewById<Button>(R.id.btn_Transferencia)
        btn_transferencia.setOnClickListener {
            val intent = Intent (this, Transferencia::class.java )
            startActivity(intent)
        }


        val btn_tarjeta = findViewById<Button>(R.id.btn_Tarjeta)
        btn_tarjeta.setOnClickListener {
            val intent = Intent (this, Tarjeta::class.java )
            startActivity(intent)
        }


        val btn_efectivo = findViewById<Button>(R.id.btn_Efectivo)
        btn_efectivo.setOnClickListener {
            val intent = Intent (this, Efectivo::class.java )
            startActivity(intent)
        }
    }
}
