package com.example.dialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add Mohit to your contact list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes"){ _,_ ->
                Toast.makeText(this,"You added Mohit to your contact list",Toast.LENGTH_SHORT).show()

            }

            .setNegativeButton("No"){ _,_ ->
                Toast.makeText(this,"You do not add Mohit to your contact list",Toast.LENGTH_SHORT).show()

            }.create()


        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }


        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one option")
            .setSingleChoiceItems(options,0){ dialogInterface, i ->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()


            }

            .setPositiveButton("Accept"){ _,_ ->
                Toast.makeText(this,"You accepted the singleChoiceDialog",Toast.LENGTH_SHORT).show()

            }

            .setNegativeButton("Decline"){ _,_ ->
                Toast.makeText(this,"You declined the singleChoiceDialog",Toast.LENGTH_SHORT).show()

            }.create()



            binding.btnDialog2.setOnClickListener {
                singleChoiceDialog.show()
            }


        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose options")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){ dialogInterface, i,isChecked ->
                if(isChecked){
                    Toast.makeText(this,"You checkeed ${options[i]}",Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this,"You unchecked ${options[i]}",Toast.LENGTH_SHORT).show()
                }


            }

            .setPositiveButton("Accept"){ _,_ ->
                Toast.makeText(this,"You accepted the multiChoiceDialog",Toast.LENGTH_SHORT).show()

            }

            .setNegativeButton("Decline"){ _,_ ->
                Toast.makeText(this,"You declined the multiChoiceDialog",Toast.LENGTH_SHORT).show()

            }.create()


        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }

    }





}