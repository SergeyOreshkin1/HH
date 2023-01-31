package com.lesson01.task03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lesson01.AppConstants.NAME
import com.lesson01.MainMenuActivity
import com.lesson01.databinding.ActivityMainTask03Binding

class MainActivityTask03 : AppCompatActivity() {

    private lateinit var binding: ActivityMainTask03Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToHelloActivity()
        navigateBack()
    }

    private fun navigateToHelloActivity() = with(binding) {
        openHelloActivityBtn.setOnClickListener {
            val intent = Intent(this@MainActivityTask03, HelloActivity::class.java)
            intent.putExtra(NAME, nameEditText.text.toString())
            startActivity(intent)
        }
    }

    private fun navigateBack() = with(binding) {
        backBtn.setOnClickListener {
            val intent = Intent(this@MainActivityTask03, MainMenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }
}
