package com.lesson01


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lesson01.databinding.ActivityMainMenuBinding
import com.lesson01.task01.MainActivityTask01
import com.lesson01.task02.MainActivityTask02
import com.lesson01.task03.MainActivityTask03

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateToTask01()
        navigateToTask02()
        navigateToTask03()
    }

    private fun navigateToTask01() = with(binding) {
        task01Btn.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, MainActivityTask01::class.java))
        }
    }

    private fun navigateToTask02() = with(binding) {
        task02Btn.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, MainActivityTask02::class.java))
        }
    }

    private fun navigateToTask03() = with(binding) {
        task03Btn.setOnClickListener {
            startActivity(Intent(this@MainMenuActivity, MainActivityTask03::class.java))
        }
    }
}
