package com.example.myapp002myownlinearlayout

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val tvInformation = findViewById<TextView>(R.id.tvInformation)
        val btnSend = findViewById<Button>(R.id.btnSend)
        val imageView = findViewById<ImageView>(R.id.imageView)  // Reference to the ImageView

        btnSend.setOnClickListener{

            val heightStr = etHeight.text.toString()
            val weightStr = etWeight.text.toString()

            if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {

                val height = heightStr.toFloat() / 100
                val weight = weightStr.toFloat()

                val bmi = weight / (height * height)

                tvInformation.text = "Tvoje BMI: $bmi"

                val threshold = 20
                if (bmi > threshold) {
                    imageView.visibility = View.VISIBLE  // Show the image
                } else {
                    imageView.visibility = View.GONE  // Hide the image if below threshold
                }
            } else {
                Toast.makeText(this, "Zadejt váhu i výšku", Toast.LENGTH_SHORT).show()
            }

        }
    }
}