package com.example.myapp006moreactivities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapp006moreactivities.databinding.ActivityMainBinding
import com.example.myapp006moreactivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()

        val twInfo = binding.twInfo

        // Načtení dat z intentu
        val nickname = intent.getStringExtra("NICK_NAME")
        twInfo.text = "Data z první aktivity. Jméno: $nickname"

        val btnBack = binding.btnBack
        btnBack.setOnClickListener {
            finish()
        }
    }
}