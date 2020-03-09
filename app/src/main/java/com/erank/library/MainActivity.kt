package com.erank.library

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val showBooksBtn by lazy { show_books }
    private val authorEt by lazy { author_et }
    private val nameET by lazy { name_et }
    private val descEt by lazy { desc_et }
    private val datePicker by lazy { date_picker }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_btn.setOnClickListener { addBook() }
        showBooksBtn.setOnClickListener {
            startActivity(Intent(this, AllBooksActivity::class.java))
        }
    }


    private fun addBook() {
        val name = nameET.text.toString()
        val author = authorEt.text.toString()
        val desc = descEt.text.toString()

        val cal = Calendar.getInstance()

        cal.set(Calendar.YEAR, datePicker.year)
        cal.set(Calendar.DAY_OF_MONTH, datePicker.dayOfMonth)
        cal.set(Calendar.MONTH, datePicker.month)

        DS.addBook(Book(name, author, desc, cal.timeInMillis))

        showBooksBtn.isEnabled = DS.books.size >= 3
    }
}
