package com.arctouch.room.model

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [QuoteV2::class, Author::class], version = 1)
abstract class QuotesWithAuthorDatabase : RoomDatabase() {

    abstract fun quotesDao(): QuotesWithAuthorDAO

    abstract fun authorsDao(): AuthorsDAO

}
