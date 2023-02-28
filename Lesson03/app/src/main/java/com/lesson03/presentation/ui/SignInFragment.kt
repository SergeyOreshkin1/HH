package com.lesson03.presentation.ui

import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.lesson03.R
import com.lesson03.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment<FragmentSignInBinding>(
    FragmentSignInBinding::inflate
) {

    private fun buttonSignInSetOnClickListener() {
        binding.buttonSignIn.setOnClickListener {
            navigateToCatalog()
        }
    }

    private fun navigateToCatalog() {
        parentFragmentManager.commit {
            replace<CatalogFragment>(R.id.container)
        }
    }

    private fun textPasswordSetOnEditorActionListener() {
        binding.textPassword.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                event.action == KeyEvent.ACTION_DOWN &&
                event.keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                navigateToCatalog()
                true
            } else {
                false
            }
        }
    }

    override fun initializeFragment() {
        buttonSignInSetOnClickListener()
        textPasswordSetOnEditorActionListener()
    }
}
