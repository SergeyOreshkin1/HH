package com.lesson02

import android.content.Context
import android.content.Intent
import android.widget.Button
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

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

    fun navigateToFragment(
        fragment: Fragment,
        @IdRes containerViewId: Int = R.id.fragmentContainerView
    ) {
        supportFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .commit()
    }
}
