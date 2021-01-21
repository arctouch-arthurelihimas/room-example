package com.arctouch.room.model

import androidx.room.*

@Dao
interface QuotesWithAuthorDAO {

    @Transaction
    @Query("SELECT * FROM quotev2")
    fun allQuotes(): List<QuoteWithAuthor>

    @Insert
    fun insertQuote(quote: QuoteV2)

    @Delete
    fun delete(quote: QuoteV2)
}