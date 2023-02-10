package com.lesson02

import android.content.Context
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun navigateBack(
        backBtn: Button,
        context: Context
    ) {
        backBtn.setOnClickListener {
            val intent = Intent(context, MainMenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }
}