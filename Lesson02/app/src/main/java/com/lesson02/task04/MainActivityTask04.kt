package com.lesson02.task04

import android.os.Bundle
import com.lesson02.BaseActivity
import com.lesson02.databinding.ActivityMainTask04Binding

class MainActivityTask04 : BaseActivity() {

    private lateinit var binding: ActivityMainTask04Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask04Binding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateBack(
            context = this@MainActivityTask04,
            backBtn = binding.backBtn
        )
    }
}
