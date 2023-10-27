package com.example.openactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.openactivity.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        binding.btnBacked.setOnClickListener {
            finish()
        }
    }
}