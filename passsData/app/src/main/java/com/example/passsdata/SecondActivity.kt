package com.example.passsdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.passsdata.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        binding.tvPerson.text = person.toString()

    }
}