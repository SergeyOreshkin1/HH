package com.lesson04.presentation.ui.task02_books.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesson04.data.repositories.MockRepository
import com.lesson04.presentation.ui.task02_books.ui_state.BookFinalModel
import com.lesson04.presentation.ui.task02_books.ui_state.BookListUiState
import com.lesson04.presentation.ui.task02_books.models.Error
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class BooksTask02ViewModel(
    private val repository: MockRepository
) : ViewModel() {

    private var _bookListUiState = MutableLiveData<List<BookListUiState>>()
    val bookListUiState get() : LiveData<List<BookListUiState>> = _bookListUiState

    private val booksListWithAvailability: MutableList<BookFinalModel> = mutableListOf()
    private val authorWithBooksList: MutableList<BookListUiState> = mutableListOf()

    private var _error = MutableLiveData<Error>()
    val error get() : LiveData<Error> = _error

    fun getResult() {
        clearData()
        viewModelScope.launch(Dispatchers.IO) {

            val books = async { repository.getBooks() }
            val authors = async { repository.getAuthors() }
            val availability = async { repository.getAvailability() }

            val booksResult = books.await()
            val authorsResult = authors.await()
            val availabilityResult = availability.await()

            booksResult.onSuccess { listBooks ->
                listBooks.forEach { book ->
                    availabilityResult.onSuccess { listAvailability ->
                        booksListWithAvailability.add(
                            BookFinalModel(
                                bookId = book.bookId,
                                inStoke = listAvailability.firstOrNull { it.bookId == book.bookId }?.inStock
                                    ?: false,
                                title = book.title,
                                authorId = book.authorId
                            )
                        )
                    }
                        .onFailure {
                            _error.postValue(Error.AVAILABILITY_ERROR_CODE)
                        }
                }
            }
                .onFailure {
                    _error.postValue(Error.BOOK_ERROR_CODE)
                }

            booksListWithAvailability.sortBy { it.title }

            authorsResult.onSuccess { listAuthors ->
                listAuthors.forEach { author ->
                    authorWithBooksList.add(
                        BookListUiState(
                            author = author.name,
                            booksList = booksListWithAvailability.filter { it.authorId == author.authorId },
                            authorId = author.authorId,
                        )
                    )
                }
            }
                .onFailure {
                    _error.postValue(Error.AUTHOR_ERROR_CODE)
                }

            _bookListUiState.postValue(
                authorWithBooksList.sortedBy { it.author }
            )
        }
    }

    private fun clearData() {
        booksListWithAvailability.clear()
        authorWithBooksList.clear()
    }
}
