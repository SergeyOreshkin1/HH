package com.lesson02.task03

import android.os.Bundle
import com.lesson02.AppConstants
import com.lesson02.BaseActivity
import com.lesson02.databinding.ActivityMainTask03Binding
import com.lesson02.MainFragmentContainerGeneral
import com.lesson02.R

class MainActivityTask03 : BaseActivity() {

    private lateinit var binding: ActivityMainTask03Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTask03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize(savedInstanceState)

        setBtnOneOnclickListener(savedInstanceState)
        setBtnTwoOnclickListener(savedInstanceState)
        setBtnThreeOnclickListener(savedInstanceState)
        setBtnAOnclickListener(savedInstanceState)
        setBtnBOnclickListener(savedInstanceState)
        setBtnCOnclickListener(savedInstanceState)

        navigateBack(
            context = this@MainActivityTask03,
            backBtn = binding.backBtn
        )
    }

    private fun initialize(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            navigateToFragment(MainFragmentContainerGeneral.newInstance(AppConstants.ONE))
            navigateToFragment(
                MainFragmentContainerGeneral.newInstance(AppConstants.A),
                containerViewId = R.id.fragmentContainerViewLetters
            )
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

    private fun setBtnAOnclickListener(savedInstanceState: Bundle?) = with(binding) {
        btnA.setOnClickListener {
            if (savedInstanceState == null) {
                navigateToFragment(
                    MainFragmentContainerGeneral.newInstance(
                        AppConstants.A
                    ),
                    containerViewId = R.id.fragmentContainerViewLetters
                )
            }
        }
    }

    private fun setBtnBOnclickListener(savedInstanceState: Bundle?) = with(binding) {
        btnB.setOnClickListener {
            if (savedInstanceState == null) {
                navigateToFragment(
                    MainFragmentContainerGeneral.newInstance(
                        AppConstants.B
                    ),
                    containerViewId = R.id.fragmentContainerViewLetters
                )
            }
        }
    }

    private fun setBtnCOnclickListener(savedInstanceState: Bundle?) = with(binding) {
        btnC.setOnClickListener {
            if (savedInstanceState == null) {
                navigateToFragment(
                    MainFragmentContainerGeneral.newInstance(
                        AppConstants.C
                    ),
                    containerViewId = R.id.fragmentContainerViewLetters
                )
            }
        }
    }
}
