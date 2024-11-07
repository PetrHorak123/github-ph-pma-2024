package com.example.myapp012imagetoapp

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp012imagetoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isGrayscale = false
    private var isSepia = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            binding.ivImage.setImageURI(uri)
            resetImageColorFilter()
        }

        binding.btnTakeImage.setOnClickListener {
            getContent.launch("image/*")
        }

        binding.btnToggleGrayscale.setOnClickListener {
            toggleGrayscale()
        }

        binding.btnToggleSepia.setOnClickListener {
            toggleSepia()
        }
    }

    private fun toggleGrayscale() {
        isGrayscale = !isGrayscale
        if (isGrayscale) {
            resetImageColorFilter()
            val colorMatrix = ColorMatrix().apply { setSaturation(0f) }
            binding.ivImage.colorFilter = ColorMatrixColorFilter(colorMatrix)
        } else {
            resetImageColorFilter()
        }
    }

    private fun toggleSepia() {
        isSepia = !isSepia
        if (isSepia) {
            resetImageColorFilter()
            val sepiaMatrix = ColorMatrix(
                floatArrayOf(
                    0.393f, 0.769f, 0.189f, 0f, 0f,
                    0.349f, 0.686f, 0.168f, 0f, 0f,
                    0.272f, 0.534f, 0.131f, 0f, 0f,
                    0f, 0f, 0f, 1f, 0f
                )
            )
            binding.ivImage.colorFilter = ColorMatrixColorFilter(sepiaMatrix)
        } else {
            resetImageColorFilter()
        }
    }

    private fun resetImageColorFilter() {
        binding.ivImage.colorFilter = null
        isGrayscale = false
        isSepia = false
    }
}
