package com.example.openactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.openactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)
        //setContentView(R.layout.activity_main)

        binding.btnOpenActivity.setOnClickListener {
            Intent( this, SecondActivity:: class.java).also {
                startActivity(it)
            }

        }

    }
}