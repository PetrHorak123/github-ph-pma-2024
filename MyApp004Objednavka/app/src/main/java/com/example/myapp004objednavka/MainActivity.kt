package com.example.myapp004objednavka

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp004objednavka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Dej si polívku"



        binding.cbPepr.setOnClickListener{
            if (binding.ivPepr.visibility == View.VISIBLE) {
                binding.ivPepr.visibility = View.INVISIBLE
            }
            else{
                binding.ivPepr.visibility = View.VISIBLE
            }
        }

        binding.cbSalt.setOnClickListener{
            if (binding.ivSalt.visibility == View.VISIBLE) {
                binding.ivSalt.visibility = View.INVISIBLE
            }
            else{
                binding.ivSalt.visibility = View.VISIBLE
            }
        }

        binding.rbGulas.setOnClickListener {
            binding.ivSoup.setImageResource(R.drawable.gulas)
        }

        binding.rbVyvar.setOnClickListener {
            binding.ivSoup.setImageResource(R.drawable.vyvar)
        }

        binding.rbZeleninova.setOnClickListener {
            binding.ivSoup.setImageResource(R.drawable.zelenina)
        }

        binding.btnOrder.setOnClickListener{
            binding.tvSummary.text = "Dobrou chuť!"
        }
    }
}