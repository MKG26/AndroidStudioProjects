package com.example.openactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.openactivity.databinding.ActivityMainBinding
import com.example.openactivity.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

            binding.btnBack.setOnClickListener {
                finish()
            }

            binding.btnNextActivity.setOnClickListener {

                Intent(this, ThirdActivity::class.java).also {
                    startActivity(it)
                }
            }

    }
}