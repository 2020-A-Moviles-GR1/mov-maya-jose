package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.firebase.database.FirebaseDatabase

class CategoriaBebidas : AppCompatActivity() {
    var clickCount1=0
    var clickCount2=0
    var clickCount3=0
    var clickCount4=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria_bebidas)

        val btn_home = findViewById<ImageButton>(R.id.btn_home)
        btn_home.setOnClickListener {
            val intent = Intent (this, Home::class.java )
            startActivity(intent)
        }


        val btn_add_coca_cola = findViewById<Button>(R.id.btn_add_cocacola)

        btn_add_coca_cola.setOnClickListener {
            clickCount1++
            saveDataCocaCola(clickCount1)

        }
        val btn_rest_coca_cola = findViewById<Button>(R.id.btn_rest_cocacola)
            btn_rest_coca_cola.setOnClickListener {
                if (clickCount1>0) {
                    clickCount1--
                    saveDataCocaCola(clickCount1)
                }
            }


        val btn_add_leche = findViewById<Button>(R.id.btn_add_leche)
        btn_add_leche.setOnClickListener {
            clickCount2++
            saveDataLeche(clickCount2)
        }

            val btn_rest_leche = findViewById<Button>(R.id.btn_rest_leche)
            btn_rest_leche.setOnClickListener {
                if (clickCount2>0){
                clickCount2--
                saveDataLeche(clickCount2)
                }
            }




        val btn_add_cerveza = findViewById<Button>(R.id.btn_add_cerveza)
        btn_add_cerveza.setOnClickListener {
            clickCount3++
            saveDataCerveza(clickCount3)
        }

        val btn_rest_cerveza = findViewById<Button>(R.id.btn_rest_cerveza)
            btn_rest_cerveza.setOnClickListener {
                if(clickCount3>0){
                clickCount3--
                saveDataCerveza(clickCount3)
                }
            }


        val btn_add_jugo = findViewById<Button>(R.id.btn_add_jugo)

        btn_add_jugo.setOnClickListener {
            clickCount4++
            saveDataJugo(clickCount4)
        }


            val btn_rest_jugo = findViewById<Button>(R.id.btn_rest_jugo)
            btn_rest_jugo.setOnClickListener {
                if(clickCount4>0){
                clickCount4--
                saveDataJugo(clickCount4)
                }
            }



        val btn_carrito_compras = findViewById<ImageButton>(R.id.btn_carrito_compras)
        btn_carrito_compras.setOnClickListener {
            val intent = Intent (this, Compras::class.java )
            startActivity(intent)
        }
    }


    fun saveDataCocaCola(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Coca Cola"
        map["precio"] = "0,95"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Bebidas").child("B001").setValue(map)
    }

    fun saveDataLeche(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Leche"
        map["precio"] = "0,85"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Bebidas").child("B002").setValue(map)
    }

    fun saveDataCerveza(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Cerveza"
        map["precio"] = "1,0"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Bebidas").child("B003").setValue(map)
    }

    fun saveDataJugo(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Jugo"
        map["precio"] = "1,50"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Bebidas").child("B004").setValue(map)
    }
}
