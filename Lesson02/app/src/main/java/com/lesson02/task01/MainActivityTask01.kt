package com.lesson02.task01

import android.os.Bundle
import com.lesson02.BaseActivity
import com.lesson02.databinding.ActivityMainTask01Binding

class MainActivityTask01 : BaseActivity() {

    private lateinit var binding: ActivityMainTask01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize(savedInstanceState)

        navigateBack(
            context = this@MainActivityTask01,
            backBtn = binding.backBtn
        )
    }

    private fun initialize(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            navigateToFragment(MainFragment.newInstance())
        }
    }
}
