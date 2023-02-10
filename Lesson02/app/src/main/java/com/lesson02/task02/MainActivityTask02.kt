package com.lesson02.task02

import android.os.Bundle
import com.lesson02.BaseActivity
import com.lesson02.databinding.ActivityMainTask02Binding

class MainActivityTask02 : BaseActivity() {

    private lateinit var binding: ActivityMainTask02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateBack(
            context = this@MainActivityTask02,
            backBtn = binding.backBtn
        )
    }
}
