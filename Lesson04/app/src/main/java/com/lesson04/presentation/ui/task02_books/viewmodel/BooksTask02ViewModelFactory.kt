package com.lesson04.presentation.ui.task02_books.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lesson04.data.repositories.MockRepository

class BooksTask02ViewModelFactory constructor(private val repository: MockRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(BooksTask02ViewModel::class.java)) {
            BooksTask02ViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
