package com.lesson02.task01

import androidx.core.os.bundleOf
import com.lesson02.BaseFragment
import com.lesson02.R
import com.lesson02.databinding.EditFragmentTask01Binding
import com.lesson02.extensions.showToast

class EditFragment : BaseFragment<EditFragmentTask01Binding>(
    EditFragmentTask01Binding::inflate
) {

    private fun saveNewMessage() = with(binding) {
        saveBtn.setOnClickListener {
            if (editMessageEditText.text.toString().isNotEmpty()) {
                (activity as MainActivityTask01).navigateToFragment(
                    MainFragment
                        .newInstance(
                            fragmentArgs = editMessageEditText.text.toString()
                        )
                )
            } else {
                showToast(resources.getString(R.string.toast_empty_error))
            }
        }
    }

    private fun getMessage() = with(binding) {
        val newMessage = arguments?.getString(ARGS_KEY)
        editMessageEditText.setText(newMessage)
    }

    override fun initializeFragment() {
        saveNewMessage()
        getMessage()
    }

    companion object {

        private const val ARGS_KEY = "ARGS_KEY"

        fun newInstance(fragmentArgs: String? = null): EditFragment {
            val args = bundleOf(
                ARGS_KEY to fragmentArgs,
            )
            val fragment = EditFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
