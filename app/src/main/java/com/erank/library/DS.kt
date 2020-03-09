package com.erank.library

import com.google.gson.Gson

object DS {
    var books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) = books.add(book)

    fun saveToDB() {
        val json = Gson().toJson(books)
//        TODO use DB
    }

    fun loadData() {
        val json: String = ""//TODO get from db
        val booksArr = Gson().fromJson(json, Array<Book>::class.java)
//        this.books = mutableListOf(booksArr)
    }

    fun getBook(pos: Int) = books[pos]
}