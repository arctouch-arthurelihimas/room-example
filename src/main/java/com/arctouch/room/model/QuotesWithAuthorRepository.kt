package com.arctouch.room.model

import android.content.Context
import androidx.room.Room
import androidx.room.Transaction

class QuotesWithAuthorRepository(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        QuotesWithAuthorDatabase::class.java,
        "quotes-v2"
    ).build()

    fun allAuthors() = db.authorsDao().allAuthors()

    fun allQuotes() = db.quotesDao().allQuotes()

    fun add(author: Author) = db.authorsDao().insertAuthor(author)

    fun add(quoteWithAuthor: QuoteV2) = db.quotesDao().insertQuote(quoteWithAuthor)

    fun delete(quote: QuoteV2) = db.quotesDao().delete(quote)

    fun delete(author: Author) = db.authorsDao().delete(author)

}
