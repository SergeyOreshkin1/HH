package com.lesson02.task01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.lesson02.databinding.MainFragmentTask01Binding

class MainFragment : BaseFragment() {

    private var _binding: MainFragmentTask01Binding? = null
    private val binding get() = requireNotNull(_binding)

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentTask01Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateToEditFragment()
        getNewMessage()
        addOnBackPressedDispatcherCallback()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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