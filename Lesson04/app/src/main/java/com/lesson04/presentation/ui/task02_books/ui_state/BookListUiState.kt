package com.lesson04.presentation.ui.task02_books.ui_state

data class BookListUiState(
    val booksList: List<BookFinalModel>,
    val author: String,
    val authorId: String
)
