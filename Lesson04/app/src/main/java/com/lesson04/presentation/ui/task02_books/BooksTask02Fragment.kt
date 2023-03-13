package com.lesson04.presentation.ui.task02_books

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.viewModels
import com.lesson04.R
import com.lesson04.data.repositories.MockRepository
import com.lesson04.databinding.FragmentBooksTask02Binding
import com.lesson04.presentation.ui.BaseFragment
import com.lesson04.presentation.ui.task02_books.recycler_view.BooksListAdapter
import com.lesson04.presentation.ui.task02_books.viewmodel.BooksTask02ViewModel
import com.lesson04.presentation.ui.task02_books.viewmodel.BooksTask02ViewModelFactory
import com.lesson04.presentation.ui.task02_books.models.Error
import com.lesson04.utils.showToast

class BooksTask02Fragment : BaseFragment<FragmentBooksTask02Binding>(
    FragmentBooksTask02Binding::inflate
) {

    private val repository = MockRepository()
    private val viewModel: BooksTask02ViewModel by viewModels {
        BooksTask02ViewModelFactory(
            repository
        )
    }

    private val booksListRvAdapter = BooksListAdapter()

    private fun navigateToMainMenu() {
        binding.backBtn.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun btnGetBooksSetOnClickListener() {
        binding.getBooksBtn.setOnClickListener {
            viewModel.clearData()
            getResult()
            binding.getBooksBtn.isEnabled = false
            android.os.Handler().postDelayed({
                binding.getBooksBtn.isEnabled = true
            }, DELAY)
        }
    }

    private fun getResult() {
        viewModel.getResult()
    }

    private fun observeError() {
        viewModel.error.observe(viewLifecycleOwner) { error ->
            when (error) {
                Error.AUTHOR_ERROR_CODE -> showToast(resources.getString(R.string.authors_error))
                Error.BOOK_ERROR_CODE -> showToast(resources.getString(R.string.books_error))
                Error.AVAILABILITY_ERROR_CODE -> showToast(resources.getString(R.string.availability_error))
                null -> {
                    /* To do nothing */
                }
            }
        }
    }

    private fun observeViewModelResult() {
        viewModel.bookListUiState.observe(viewLifecycleOwner) { state ->
            booksListRvAdapter.submitList(state)
            if (state.isNotEmpty()) updateLayout(ZERO_BIAS, ZERO_BIAS) else updateLayout(
                HALF_BIAS,
                HALF_BIAS
            )
        }
    }

    private fun initRecyclerView() {
        with(binding.booksRecyclerView) {
            adapter = booksListRvAdapter
        }
    }

    private fun updateLayout(vb: Float, hb: Float) = with(binding) {
        getBooksBtn.updateLayoutParams<ConstraintLayout.LayoutParams> {
            topToTop = ConstraintLayout.LayoutParams.UNSET
            topToBottom = booksRecyclerView.id
            verticalBias = vb
            horizontalBias = hb
        }
    }

    override fun initializeFragment() {
        initRecyclerView()
        observeViewModelResult()
        navigateToMainMenu()
        btnGetBooksSetOnClickListener()
        observeError()
    }

    companion object {
        private const val HALF_BIAS = 0.5F
        private const val ZERO_BIAS = 0.0F
        private const val DELAY = 1000L
    }
}
