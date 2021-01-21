package com.arctouch.room.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//step 2 create dao
@Dao
interface QuotesDAO {

    @Query("SELECT * FROM quote")
    fun allQuotes(): LiveData<List<Quote>>

    @Insert
    fun insertQuote(quote: Quote)
}