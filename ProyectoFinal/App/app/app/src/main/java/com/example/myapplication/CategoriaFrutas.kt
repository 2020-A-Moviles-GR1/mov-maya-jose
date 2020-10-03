package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.firebase.database.FirebaseDatabase

class CategoriaFrutas : AppCompatActivity() {
    var clickCount1=0
    var clickCount2=0
    var clickCount3=0
    var clickCount4=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria_frutas)

        val btn_home = findViewById<ImageButton>(R.id.btn_home)
        btn_home.setOnClickListener {
            val intent = Intent (this, Home::class.java )
            startActivity(intent)
        }


        val btn_add_coco = findViewById<Button>(R.id.btn_add_coco)
        btn_add_coco.setOnClickListener {
            clickCount1++
            saveDataCoco(clickCount1)
        }

        val btn_rest_coco = findViewById<Button>(R.id.btn_rest_coco)
        btn_rest_coco.setOnClickListener {
            if (clickCount1>0) {
                clickCount1--
                saveDataCoco(clickCount1)
            }
        }

        val btn_add_sandia = findViewById<Button>(R.id.btn_add_sandia)
        btn_add_sandia.setOnClickListener {
            clickCount2++
            saveDataSandia(clickCount2)
        }

        val btn_rest_sandia = findViewById<Button>(R.id.btn_rest_sandia)
        btn_rest_sandia.setOnClickListener {
            if(clickCount2>0) {
                clickCount2--
                saveDataSandia(clickCount2)
            }
        }

        val btn_add_platano = findViewById<Button>(R.id.btn_add_platano)
        btn_add_platano.setOnClickListener {
            clickCount3++
            saveDataPlatano(clickCount3)
        }

        val btn_rest_platano = findViewById<Button>(R.id.btn_rest_platano)
        btn_rest_platano.setOnClickListener {
            if(clickCount3>0) {
                clickCount3--
                saveDataPlatano(clickCount3)
            }
        }

        val btn_add_naranja = findViewById<Button>(R.id.btn_add_naranja)
        btn_add_naranja.setOnClickListener {
            clickCount4++
            saveDataNaranja(clickCount4)
        }

        val btn_rest_naranja = findViewById<Button>(R.id.btn_rest_naranja)
        btn_rest_naranja.setOnClickListener {
            if(clickCount4>0) {
                clickCount4--
                saveDataNaranja(clickCount4)
            }
        }

        val btn_carrito_compras = findViewById<ImageButton>(R.id.btn_carrito_compras)
        btn_carrito_compras.setOnClickListener {
            val intent = Intent (this, Compras::class.java )
            startActivity(intent)
        }


    }


    fun saveDataCoco(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Coco"
        map["precio"] = "1,50"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Frutas").child("F001").setValue(map)
    }

    fun saveDataSandia(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Sandia"
        map["precio"] = "1,25"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Frutas").child("F002").setValue(map)
    }

    fun saveDataPlatano(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Platano"
        map["precio"] = "1,75"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Frutas").child("F003").setValue(map)
    }

    fun saveDataNaranja(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Naranja"
        map["precio"] = "1,00"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Frutas").child("F004").setValue(map)
    }
}
