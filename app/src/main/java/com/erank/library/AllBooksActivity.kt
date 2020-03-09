package com.erank.library

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_all_books.*

class AllBooksActivity : AppCompatActivity(), BooksAdapter.OnBookClickCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_books)

        val booksAdapter = BooksAdapter(DS.books)
        recycler.adapter = booksAdapter
        booksAdapter.onBookClickCallbackCallback = this
    }

    override fun onClick(book: Book, pos: Int) {
        val intent = Intent(this, BookActivity::class.java)
            .putExtra("bookIndex",pos)

        startActivity(intent)
    }
}
