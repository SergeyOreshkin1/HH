package com.lesson02.task02

import android.os.Bundle
import com.lesson02.AppConstants
import com.lesson02.BaseActivity
import com.lesson02.MainFragmentContainerGeneral
import com.lesson02.databinding.ActivityMainTask02Binding

class MainActivityTask02 : BaseActivity() {

    private lateinit var binding: ActivityMainTask02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize(savedInstanceState)

        setBtnOneOnclickListener(savedInstanceState)
        setBtnTwoOnclickListener(savedInstanceState)
        setBtnThreeOnclickListener(savedInstanceState)

        navigateBack(
            context = this@MainActivityTask02,
            backBtn = binding.backBtn
        )
    }

    private fun initialize(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            navigateToFragment(MainFragmentContainerGeneral.newInstance(AppConstants.ONE))
        }
    }

    private fun setBtnOneOnclickListener(savedInstanceState: Bundle?) = with(binding) {
        btnOne.setOnClickListener {
            if (savedInstanceState == null) {
                navigateToFragment(MainFragmentContainerGeneral.newInstance(AppConstants.ONE))
            }
        }
    }

    private fun setBtnTwoOnclickListener(savedInstanceState: Bundle?) = with(binding) {
        btnTwo.setOnClickListener {
            if (savedInstanceState == null) {
                navigateToFragment(MainFragmentContainerGeneral.newInstance(AppConstants.TWO))
            }
        }
    }

    private fun setBtnThreeOnclickListener(savedInstanceState: Bundle?) = with(binding) {
        btnThree.setOnClickListener {
            if (savedInstanceState == null) {
                navigateToFragment(MainFragmentContainerGeneral.newInstance(AppConstants.THREE))
            }
        }
    }
}
