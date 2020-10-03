package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.firebase.database.FirebaseDatabase

class CategoriaEnlatados : AppCompatActivity() {

    var clickCount1=0
    var clickCount2=0
    var clickCount3=0
    var clickCount4=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria_enlatados)

        val btn_home = findViewById<ImageButton>(R.id.btn_home)
        btn_home.setOnClickListener {
            val intent = Intent (this, Home::class.java )
            startActivity(intent)
        }

        val btn_add_durazno = findViewById<Button>(R.id.btn_add_durazno)
        btn_add_durazno.setOnClickListener {
            clickCount1++
            saveDataDurazno(clickCount1)

        }

        val btn_rest_durazno = findViewById<Button>(R.id.btn_rest_durazno)
        btn_rest_durazno.setOnClickListener {
            if(clickCount1>0) {
                clickCount1--
                saveDataDurazno(clickCount1)
            }
        }

        val btn_add_fideo = findViewById<Button>(R.id.btn_add_fideo)
        btn_add_fideo.setOnClickListener {
            clickCount2++
            saveDataFideo(clickCount2)
        }

        val btn_rest_fideo = findViewById<Button>(R.id.btn_rest_fideo)
        btn_rest_fideo.setOnClickListener {
            if(clickCount2>0){
            clickCount2--
            saveDataFideo(clickCount2)
            }
        }

        val btn_add_maiz = findViewById<Button>(R.id.btn_add_maiz)
        btn_add_maiz.setOnClickListener {
            clickCount3++
            saveDataMaiz(clickCount3)
        }

        val btn_rest_maiz = findViewById<Button>(R.id.btn_rest_maiz)
        btn_rest_maiz.setOnClickListener {
            if(clickCount3>0) {
                clickCount3--
                saveDataMaiz(clickCount3)
            }
        }

        val btn_add_tomate = findViewById<Button>(R.id.btn_add_tomate)
        btn_add_tomate.setOnClickListener {
            clickCount4++
            saveDataTomate(clickCount4)

        }

        val btn_rest_tomate = findViewById<Button>(R.id.btn_rest_tomate)
        btn_rest_tomate.setOnClickListener {
            if(clickCount4>0){
                clickCount4--
                saveDataTomate(clickCount4)
            }

        }

        val btn_carrito_compras = findViewById<ImageButton>(R.id.btn_carrito_compras)
        btn_carrito_compras.setOnClickListener {
            val intent = Intent (this, Compras::class.java )
            startActivity(intent)
        }
    }


    fun saveDataDurazno(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Durazno"
        map["precio"] = "2,55"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Enlatados").child("E001").setValue(map)
    }

    fun saveDataFideo(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Fideo"
        map["precio"] = "2,25"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Enlatados").child("E002").setValue(map)
    }

    fun saveDataTomate(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Tomate"
        map["precio"] = "2,0"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Enlatados").child("E003").setValue(map)
    }

    fun saveDataMaiz(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "Maiz"
        map["precio"] = "2,50"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Enlatados").child("E004").setValue(map)
    }
}
