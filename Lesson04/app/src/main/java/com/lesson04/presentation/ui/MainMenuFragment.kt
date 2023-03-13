package com.lesson04.presentation.ui

import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.lesson04.R
import com.lesson04.databinding.FragmentMenuBinding
import com.lesson04.presentation.ui.task01_weather.WeatherTask01Fragment
import com.lesson04.presentation.ui.task02_books.BooksTask02Fragment

class MainMenuFragment : BaseFragment<FragmentMenuBinding>(
    FragmentMenuBinding::inflate
) {

    private fun buttonTask01SetOnClickListener() {
        binding.task01Btn.setOnClickListener {
            navigateToTask01()
        }
    }

    private fun buttonTask02SetOnClickListener() {
        binding.task02Btn.setOnClickListener {
            navigateToTask02()
        }
    }

    private fun navigateToTask01() {
        parentFragmentManager.commit {
            replace<WeatherTask01Fragment>(R.id.container)
            addToBackStack(FRAGMENT_TASK01)
        }
    }

    private fun navigateToTask02() {
        parentFragmentManager.commit {
            replace<BooksTask02Fragment>(R.id.container)
            addToBackStack(FRAGMENT_TASK02)
        }
    }

    override fun initializeFragment() {
        buttonTask01SetOnClickListener()
        buttonTask02SetOnClickListener()
    }

    companion object {
        private const val FRAGMENT_TASK01 = "fragment_task01"
        private const val FRAGMENT_TASK02 = "fragment_task02"
    }
}
