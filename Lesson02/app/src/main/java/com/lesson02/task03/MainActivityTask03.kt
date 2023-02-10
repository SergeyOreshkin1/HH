package com.lesson02.task03

import android.os.Bundle
import com.lesson02.BaseActivity
import com.lesson02.databinding.ActivityMainTask03Binding

class MainActivityTask03 : BaseActivity() {

    private lateinit var binding: ActivityMainTask03Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        navigateBack(
            context = this@MainActivityTask03,
            backBtn = binding.backBtn
        )
    }
}
