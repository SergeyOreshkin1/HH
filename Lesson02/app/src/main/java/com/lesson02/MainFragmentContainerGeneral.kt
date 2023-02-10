package com.lesson02

import androidx.core.os.bundleOf
import com.lesson02.databinding.MainFragmentContainerGeneralBinding

class MainFragmentContainerGeneral : BaseFragment<MainFragmentContainerGeneralBinding>(
    MainFragmentContainerGeneralBinding::inflate
) {

    private fun getArgs() = with(binding) {
        argumentTextView.text = arguments?.getString(ARGS_KEY)
    }

    override fun initializeFragment() {
        getArgs()
    }

    companion object {

        private const val ARGS_KEY = "ARGS_KEY"

        fun newInstance(fragmentArgs: String? = null): MainFragmentContainerGeneral {
            val args = bundleOf(
                ARGS_KEY to fragmentArgs,
            )
            val fragment = MainFragmentContainerGeneral()
            fragment.arguments = args
            return fragment
        }
    }
}
