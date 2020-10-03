package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CategoriaPan : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    var clickCount1 = 0
    var clickCount2 = 0
    var clickCount3 = 0
    var clickCount4 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria_pan)

        clickCount1 += if (intent.getStringExtra("ClickCountPan1") == null) 0 else intent.getStringExtra("ClickCountPan1").toInt()
        Log.v("CategoriaPan", clickCount1.toString())
        clickCount2 += if (intent.getStringExtra("ClickCountPan2") == null) 0 else intent.getStringExtra("ClickCountPan2").toInt()
        clickCount3 += if (intent.getStringExtra("ClickCountPan3") == null) 0 else intent.getStringExtra("ClickCountPan3").toInt()
        clickCount4 += if (intent.getStringExtra("ClickCountPan4") == null) 0 else intent.getStringExtra("ClickCountPan4").toInt()

        val btn_home = findViewById<ImageButton>(R.id.btn_home)
        btn_home.setOnClickListener {
            val intent = Intent (this, Home::class.java )
            intent.putExtra("ClickCount1", clickCount1.toString())
            intent.putExtra("ClickCount2", clickCount2.toString())
            intent.putExtra("ClickCount3", clickCount3.toString())
            intent.putExtra("ClickCount4", clickCount4.toString())
            startActivity(intent)
        }

        val btn_add_tostadas = findViewById<Button>(R.id.btn_add_tostada)
        btn_add_tostadas.setOnClickListener {
            clickCount1++
            saveDataTostada(clickCount1)
        }

        val btn_rest_tostadas = findViewById<Button>(R.id.btn_rest_tostada)
        btn_rest_tostadas.setOnClickListener {
            if (clickCount1>0) {
                clickCount1--
                saveDataTostada(clickCount1)
            }
        }

        val btn_add_cachito = findViewById<Button>(R.id.btn_add_cachito)
        btn_add_cachito.setOnClickListener {
            clickCount2++
            saveDataCachito(clickCount2)
        }

        val btn_rest_cachito = findViewById<Button>(R.id.btn_rest_cachito)
        btn_rest_cachito.setOnClickListener {
            if(clickCount2>0) {
                clickCount2--
                saveDataCachito(clickCount2)
            }
        }


        val btn_add_donas = findViewById<Button>(R.id.btn_add_donas)
        btn_add_donas.setOnClickListener {
            clickCount3++
            saveDataDonas(clickCount3)
        }

        val btn_rest_donas = findViewById<Button>(R.id.btn_rest_donas)
        btn_rest_donas.setOnClickListener {
            if(clickCount3>0) {
                clickCount3--
                saveDataDonas(clickCount3)
            }
        }

        val btn_add_pan = findViewById<Button>(R.id.btn_add_pan)
        btn_add_pan.setOnClickListener {
            clickCount4++
            saveDataPan(clickCount4)
        }

        val btn_rest_pan = findViewById<Button>(R.id.btn_rest_pan)
        btn_rest_pan.setOnClickListener {
            if(clickCount4>0) {
                clickCount4--
                saveDataPan(clickCount4)
            }
        }


        val btn_carrito_compras = findViewById<ImageButton>(R.id.btn_carrito_compras)
        btn_carrito_compras.setOnClickListener {
            val intent = Intent (this, Compras::class.java )

        }
    }

    fun saveDataTostada(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "tostada"
        map["precio"] = "0,15"
        map["cantidad"] = clickCount
        FirebaseDatabase.getInstance().reference.child("Categoria Pan").child("P001").setValue(map)
    }

    fun saveDataPan(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "pan"
        map["precio"] = "0,10"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Pan").child("P002").setValue(map)
    }

    fun saveDataCachito(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "cachito"
        map["precio"] = "0,15"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Pan").child("P003").setValue(map)
    }
    fun saveDataDonas(clickCount: Int){

        var map = mutableMapOf<String,Any>()
        map["name"] = "fona"
        map["precio"] = "0,25"
        map["cantidad"] = clickCount

        FirebaseDatabase.getInstance().reference.child("Categoria Pan").child("P004").setValue(map)
    }
}
