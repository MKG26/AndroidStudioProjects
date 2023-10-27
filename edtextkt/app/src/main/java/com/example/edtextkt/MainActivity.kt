package com.example.edtextkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val etFirstNum = findViewById<EditText>(R.id.etFirstNum)
        val etSecondNum = findViewById<EditText>(R.id.etSecondNum)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnAdd.setOnClickListener {
            val firstNumber = etFirstNum.text.toString().toInt()
            val secondNumber = etSecondNum.text.toString().toInt()
            val result = firstNumber + secondNumber
            tvResult.text = result.toString()
        }
    }
}