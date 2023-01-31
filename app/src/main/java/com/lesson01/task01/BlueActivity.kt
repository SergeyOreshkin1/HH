package com.lesson01.task01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lesson01.databinding.ActivityBlueBinding

class BlueActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlueBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateBack()
    }

    private fun navigateBack() = with(binding) {
        backBtn.setOnClickListener {
            val intent = Intent(this@BlueActivity, MainActivityTask01::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }
}
