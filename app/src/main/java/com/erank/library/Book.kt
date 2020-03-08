package com.erank.library

import java.util.*

class Book(
    val name: String,
    val author: String,
    val description: String
) {
    val id: Long

    init {
        id = UUID.randomUUID().node()
    }
} 