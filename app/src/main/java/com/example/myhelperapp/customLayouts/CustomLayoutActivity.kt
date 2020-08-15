package com.example.myhelperapp.customLayouts

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myhelperapp.R
import kotlinx.android.synthetic.main.activity_custom_layout.*

class CustomLayoutActivity : AppCompatActivity() {

    private val itemList: List<String> = listOf("---select gender---", "Male", "Female", "Other")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_layout)

        val spinner: Spinner = findViewById(R.id.custom_layout_spinner)
        val spinner1: Spinner = findViewById(R.id.custom_layout_spinner1)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)

        spinner.adapter = arrayAdapter
        spinner1.adapter = arrayAdapter

        custom_layout_spinner_validation_button.setOnClickListener {
            if (spinner1.selectedItemPosition == 0) {
                Toast.makeText(this, "Invalid selection", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Valid selection", Toast.LENGTH_SHORT).show()
            }
        }

        custom_layout_pop_up.setOnClickListener {
            customAlertDialog()
        }

    }

    private fun simpleAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Simple Alert Dialog")
            .setMessage("This is a simple alert dialog")
            .setPositiveButton("OK") { dialog, which ->
                Toast.makeText(this, "Ok is pressed", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(this, "Cancel is pressed", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Neutral") { dialog, which ->
                Toast.makeText(this, "Neutral is pressed", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showListAlert() {
        val items = arrayOf("Camera", "Gallery")

        AlertDialog.Builder(this)
            .setTitle("Choose")
            .setItems(items) {dialog, which ->
                if (items[which] == "Camera") {
                    Toast.makeText(this, "Camera is pressed", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Gallery is pressed", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel") {dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

    private fun customAlertDialog() {

        val dialogView = layoutInflater.inflate(R.layout.custom_alert_dialog_layout, null)

        val customDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .show()

        val btLeave = dialogView.findViewById<Button>(R.id.btLeave)
        val btCancel = dialogView.findViewById<Button>(R.id.btCancel)
        btLeave.setOnClickListener {
            customDialog.dismiss()
            Toast.makeText(this, "Yes, Leave It! clicked", Toast.LENGTH_SHORT).show()
        }

        btCancel.setOnClickListener {
            customDialog.dismiss()
            Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show()
        }

    }

}