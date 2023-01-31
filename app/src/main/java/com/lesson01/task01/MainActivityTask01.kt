package com.lesson01.task01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lesson01.MainMenuActivity
import com.lesson01.databinding.ActivityMainTask01Binding

class MainActivityTask01 : AppCompatActivity() {

    private lateinit var binding: ActivityMainTask01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToRedActivity()
        navigateToGreenActivity()
        navigateToBlueActivity()
        navigateBack()
    }

    private fun navigateToRedActivity() = with(binding) {
        openRedActivityBtn.setOnClickListener {
            startActivity(Intent(this@MainActivityTask01, RedActivity::class.java))
        }
    }

    private fun navigateToGreenActivity() = with(binding) {
        openGreenActivityBtn.setOnClickListener {
            startActivity(Intent(this@MainActivityTask01, GreenActivity::class.java))
        }
    }

    private fun navigateToBlueActivity() = with(binding) {
        openBlueActivityBtn.setOnClickListener {
            startActivity(Intent(this@MainActivityTask01, BlueActivity::class.java))
        }
    }

    private fun navigateBack() = with(binding) {
        backBtn.setOnClickListener {
            val intent = Intent(this@MainActivityTask01, MainMenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }
}
