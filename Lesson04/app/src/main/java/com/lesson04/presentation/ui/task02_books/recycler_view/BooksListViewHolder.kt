package com.lesson04.presentation.ui.task02_books.recycler_view

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lesson04.R
import com.lesson04.databinding.RvItemAuthorCellBinding
import com.lesson04.presentation.ui.task02_books.ui_state.BookListUiState
import java.util.*

private const val DELIMITER = ", \n"

class BooksListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("StringFormatMatches")
    fun bind(
        item: BookListUiState,
    ) {
        with(RvItemAuthorCellBinding.bind(itemView)) {
            if (item.booksList.isNotEmpty() && item.author.isNotEmpty()) {
                authorTextView.text = item.author
                val onlyBooksTitlesList = requireNotNull(item.booksList).map {
                    itemView.context.getString(
                        R.string.books_with_status_availability,
                        it.title,
                        if (it.inStoke) itemView.context.getString(R.string.in_stoke_true)
                        else itemView.context.getString(R.string.in_stoke_false)
                    )
                }

                val joinedBooksList: String? =
                    onlyBooksTitlesList.let { java.lang.String.join(DELIMITER, it) }
                booksTextView.text = joinedBooksList
            }
        }
    }
}
