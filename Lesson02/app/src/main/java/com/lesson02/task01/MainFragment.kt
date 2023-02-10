package com.lesson02.task01

import androidx.core.os.bundleOf
import com.lesson02.BaseFragment
import com.lesson02.databinding.MainFragmentTask01Binding

class MainFragment : BaseFragment<MainFragmentTask01Binding>(
    MainFragmentTask01Binding::inflate
) {

    private fun navigateToEditFragment() = with(binding) {
        continueBtn.setOnClickListener {
            (activity as MainActivityTask01).navigateToFragment(
                EditFragment.newInstance(
                    messageTextView.text.toString()
                )
            )
        }
    }

    private fun getNewMessage() = with(binding) {
        val newMessage = arguments?.getString(ARGS_KEY)
        newMessage?.let {
            messageTextView.text = newMessage
        }
    }

    override fun initializeFragment() {
        navigateToEditFragment()
        getNewMessage()
    }

    companion object {

        private const val ARGS_KEY = "ARGS_KEY"

        fun newInstance(fragmentArgs: String? = null): MainFragment {
            val args = bundleOf(
                ARGS_KEY to fragmentArgs,
            )
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
