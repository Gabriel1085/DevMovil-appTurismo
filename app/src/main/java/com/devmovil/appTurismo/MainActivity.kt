package com.devmovil.appTurismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtlagunacocha.setOnClickListener {
            val intent: Intent = Intent(this, LagunadelaCocha::class.java)
            startActivity(intent)
        }
        txtgaleras.setOnClickListener {
            val intent: Intent = Intent(this, volcangaleras::class.java)
            startActivity(intent)
        }
    }
}