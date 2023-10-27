package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        val customList = listOf("Fisrt", "Second" , "Third" , "Fourth")
        val adaptor = ArrayAdapter<String>(this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,customList)
        binding.spMonths.adapter = adaptor


        binding.spMonths.onItemSelectedListener = object : OnItemSelectedListener{
             override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                 Toast.makeText(this@MainActivity, "You Selected ${adapterView?.getItemAtPosition(position).toString()}",Toast.LENGTH_LONG).show()
             }

             override fun onNothingSelected(p0: AdapterView<*>?) {
             }
         }

    }
}