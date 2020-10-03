package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class Home : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    var clickCount1 = 0
    var clickCount2 = 0
    var clickCount3 = 0
    var clickCount4 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        clickCount1 += if (intent.getStringExtra("ClickCount1") == null) 0 else intent.getStringExtra("ClickCount1").toString().toInt()
        clickCount2 += if (intent.getStringExtra("ClickCount2") == null) 0 else intent.getStringExtra("ClickCount2").toString().toInt()
        clickCount3 += if (intent.getStringExtra("ClickCount3") == null) 0 else intent.getStringExtra("ClickCount3").toString().toInt()
        clickCount4 += if (intent.getStringExtra("ClickCount4") == null) 0 else intent.getStringExtra("ClickCount4").toString().toInt()
        Log.v("Home", clickCount1.toString())
                val btn_panes = findViewById<ImageButton>(R.id.btn_panes)
            btn_panes.setOnClickListener {
                val intent = Intent(this, CategoriaPan::class.java)
                intent.putExtra("ClickCountPan1", clickCount1.toString())
            intent.putExtra("ClickCountPan2", clickCount2.toString())
            intent.putExtra("ClickCountPan3", clickCount3.toString())
            intent.putExtra("ClickCountPan4", clickCount4.toString())
            startActivity(intent)
        }

        val btn_logOut = findViewById<ImageButton>(R.id.btn_logOut)
        btn_logOut.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        val btn_enlatados = findViewById<ImageButton>(R.id.btn_enlatados)
        btn_enlatados.setOnClickListener {
            val intent = Intent(this, CategoriaEnlatados::class.java)
            startActivity(intent)
        }

        val btn_bebidas = findViewById<ImageButton>(R.id.btn_bebidas)
        btn_bebidas.setOnClickListener {
            val intent = Intent(this, CategoriaBebidas::class.java)
            startActivity(intent)
        }

        val btn_frutas = findViewById<ImageButton>(R.id.btn_frutas)
        btn_frutas.setOnClickListener {
            val intent = Intent(this, CategoriaFrutas::class.java)
            startActivity(intent)
        }

        val btn_buy = findViewById<Button>(R.id.btn_buy)
        btn_buy.setOnClickListener{
            val intent = Intent(this, Compras::class.java)
            startActivity(intent)
        }

    }

}
