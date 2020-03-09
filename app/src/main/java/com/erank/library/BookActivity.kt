package com.erank.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book.*
import kotlinx.android.synthetic.main.activity_book.author_tv
import kotlinx.android.synthetic.main.activity_book.date_tv
import kotlinx.android.synthetic.main.activity_book.name_tv
import kotlinx.android.synthetic.main.book_item.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class BookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val pos = intent.getIntExtra("bookIndex", -1)
        if (pos != -1) {
            fill(DS.getBook(pos))
        }
    }

    private fun fill(book: Book) = with(book){
        name_tv.text = name
        author_tv.text = author
        description_tv.text = description

        val formatter = SimpleDateFormat.getDateInstance(DateFormat.MEDIUM)
        val date = formatter.format(Date(timeStamp))
        date_tv.text = date
    }
}
