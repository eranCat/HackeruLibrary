package com.erank.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book_item.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class BooksAdapter(private val books: MutableList<Book>) :
    RecyclerView.Adapter<BooksAdapter.BookVH>() {

    var onBookClickCallbackCallback: OnBookClickCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BookVH(parent)

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookVH, i: Int) {
        holder.fill(books[i])
    }

    inner class BookVH(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.book_item, parent, false)
    ) {

        fun fill(book: Book) = with(itemView) {
            name_tv.text = book.name
            author_tv.text = book.author
            desc_tv.text = book.description
            val date = Date(book.timeStamp)
            val formatter = SimpleDateFormat.getDateInstance(DateFormat.MEDIUM)
            date_tv.text = formatter.format(date)

            itemView.setOnClickListener {
                onBookClickCallbackCallback?.onClick(book, adapterPosition)
            }
        }
    }

    interface OnBookClickCallback {
        fun onClick(book: Book, pos: Int)
    }
}