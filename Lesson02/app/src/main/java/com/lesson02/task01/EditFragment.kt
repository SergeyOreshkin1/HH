package com.lesson02.task01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import com.lesson02.R
import com.lesson02.databinding.EditFragmentTask01Binding

class EditFragment : BaseFragment() {

    private var _binding: EditFragmentTask01Binding? = null
    private val binding get() = requireNotNull(_binding)

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
                showError()
            }
        }
    }

    private fun getMessage() = with(binding) {
        val newMessage = arguments?.getString(ARGS_KEY)
        editMessageEditText.setText(newMessage)
    }

    private fun showError() {
        Toast.makeText(
            requireContext(),
            resources.getString(R.string.toast_empty_error),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EditFragmentTask01Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMessage()
        saveNewMessage()
        addOnBackPressedDispatcherCallback()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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