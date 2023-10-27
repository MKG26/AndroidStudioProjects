package com.example.imagekt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddImage = findViewById<Button>(R.id.btnAddImage)
        val ivImage = findViewById<ImageView>(R.id.ivImage)

        btnAddImage.setOnClickListener {

            ivImage.setImageResource(R.drawable.img)
        }
    }
}