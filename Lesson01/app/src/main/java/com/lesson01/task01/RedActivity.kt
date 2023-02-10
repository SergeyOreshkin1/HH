package com.lesson01.task01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lesson01.databinding.ActivityRedBinding

class RedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateBack()
    }

    private fun navigateBack() = with(binding) {
        backBtn.setOnClickListener {
            val intent = Intent(this@RedActivity, MainActivityTask01::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }
}
