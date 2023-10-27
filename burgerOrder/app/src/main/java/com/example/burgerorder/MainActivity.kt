package com.example.burgerorder

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        val rgMeat = findViewById<RadioGroup>(R.id.rgMeat)
        val cbCheese = findViewById<CheckBox>(R.id.cbCheese)
        val cbOnion = findViewById<CheckBox>(R.id.cbOnion)
        val cbSalad = findViewById<CheckBox>(R.id.cbSalad)
        val tvTest = findViewById<TextView>(R.id.tvTest)

        btnOrder.setOnClickListener {
            val checkedMeatRadioButtonId = rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)
            val cheese = cbCheese.isChecked
            val onion = cbOnion.isChecked
            val salad = cbSalad.isChecked
            val orderString = "You ordered a burger with:\n"+
                    "${meat.text}"+
                    (if(cheese) "\nCheese" else "")+
                    (if(onion) "\nOnion" else "")+
                    (if(salad) "\nSalad" else "")
           tvTest.text = orderString
        }

    }
}