package com.lesson01.task02

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lesson01.AppConstants
import com.lesson01.MainMenuActivity
import com.lesson01.R
import com.lesson01.databinding.ActivityMainTask02Binding
import com.lesson01.task03.TextPattern

class MainActivityTask02 : AppCompatActivity() {

    private lateinit var binding: ActivityMainTask02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setOpenBtnClickListener()
        navigateBack()
    }

    private fun setOpenBtnClickListener() = with(binding) {
        openBtn.setOnClickListener {
            if (TextPattern.EMAIL.pattern.matcher(editText.text.toString()).matches()) {
                openEmail()
            } else if (TextPattern.LINK.pattern.matcher(editText.text.toString()).matches()) {
                openLink()
            } else if (TextPattern.PHONE_RU.pattern.matcher(editText.text.toString()).matches()) {
                openPhone()
            } else if (TextPattern.MAP_COORDINATES.pattern.matcher(editText.text.toString())
                    .matches()
            ) {
                openMap()
            } else {
                showError()
            }
        }
    }

    private fun openEmail() = with(binding) {
        val emailIntent =
            Intent(
                Intent.ACTION_SENDTO,
                Uri.fromParts(AppConstants.MAILTO, editText.text.toString(), null)
            )
        startActivity(Intent.createChooser(emailIntent, AppConstants.SEND_TITLE))
    }

    private fun openLink() = with(binding) {
        val linkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(editText.text.toString()))
        startActivity(linkIntent)
    }

    private fun openPhone() = with(binding) {
        val phoneNumberIntent =
            Intent(
                Intent.ACTION_DIAL,
                Uri.parse(AppConstants.TEL + Uri.encode(editText.text.toString()))
            )
        startActivity(phoneNumberIntent)
    }

    private fun openMap() = with(binding) {
        val mapIntent =
            Intent(Intent.ACTION_VIEW, Uri.parse(AppConstants.GEO + editText.text.toString()))
        startActivity(mapIntent)
    }

    private fun showError() {
        Toast.makeText(
            this@MainActivityTask02,
            resources.getString(R.string.wrong_format),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun navigateBack() = with(binding) {
        backBtn.setOnClickListener {
            val intent = Intent(this@MainActivityTask02, MainMenuActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            startActivity(intent)
        }
    }
}
