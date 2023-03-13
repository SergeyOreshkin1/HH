package com.lesson04.presentation.ui.task02_books.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.lesson04.R
import com.lesson04.presentation.ui.task02_books.ui_state.BookListUiState

private val diffCallBack = object : DiffUtil.ItemCallback<BookListUiState>() {

    override fun areItemsTheSame(
        oldItem: BookListUiState,
        newItem: BookListUiState
    ): Boolean = oldItem.authorId == newItem.authorId

    override fun areContentsTheSame(
        oldItem: BookListUiState,
        newItem: BookListUiState
    ): Boolean = oldItem == newItem
}

class BooksListAdapter(
) : ListAdapter<BookListUiState, BooksListViewHolder>(diffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksListViewHolder {
        val layout = R.layout.rv_item_author_cell
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return BooksListViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksListViewHolder, position: Int) {
        holder.bind(
            currentList[position],
        )
    }
}
