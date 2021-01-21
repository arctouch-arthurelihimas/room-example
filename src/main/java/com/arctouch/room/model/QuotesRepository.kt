package com.arctouch.room.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room

/**...
 * step 4 instantiate database and use dao
 */

class QuotesRepository(context: Context) {

    private val db = Room.databaseBuilder(
        context,
        QuotesDatabase::class.java,
        "quotes-db"
    )
        .build()

    private val quotesList = mutableListOf(
        Quote("A tentativa é o primeiro passo para o fracasso"),
        Quote("Jacaré que dorme vira bolsa"),
        Quote("Se algo é difícil de fazer, então não vale a pena ser feito")
    )

    fun add(quote: Quote) {
        //code without persistence
        //quotesList.add(quote)

        //code with persistence
        db.quotesDAO().insertQuote(quote)
    }


    fun getQuotes(): LiveData<List<Quote>> {
        //code without persistence
        //return quotesList

        //code with persistence
        return db.quotesDAO().allQuotes()
    }


}
