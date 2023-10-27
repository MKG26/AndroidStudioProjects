package com.example.toastkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.viewbinding.ViewBinding
import com.example.toastkt.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)
        //setContentView(R.layout.activity_main)



        binding.btnShowToast.setOnClickListener {

            Toast(this).apply {
                duration = Toast.LENGTH_LONG
                  view = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.clToast))
                show()
            }

        }

    }
}