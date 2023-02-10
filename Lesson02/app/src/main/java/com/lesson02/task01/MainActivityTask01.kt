package com.lesson02.task01

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lesson02.BaseActivity
import com.lesson02.R
import com.lesson02.databinding.ActivityMainTask01Binding

class MainActivityTask01 : BaseActivity() {

    private lateinit var binding: ActivityMainTask01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            navigateToFragment(MainFragment.newInstance())
        }

        navigateBack(
            context = this@MainActivityTask01,
            backBtn = binding.backBtn
        )
    }

    fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .addToBackStack(fragment.javaClass.name)
            .commit()
    }
}
