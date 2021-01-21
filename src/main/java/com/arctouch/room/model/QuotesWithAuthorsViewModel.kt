package com.arctouch.room.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuotesWithAuthorsViewModel(private val repository: QuotesWithAuthorRepository) : ViewModel() {

    val quotesLiveData = MutableLiveData<List<QuoteWithAuthor>>()
    val authorsLiveData = MutableLiveData<List<Author>>()

    fun loadAuthorsAndQuotes() {
        GlobalScope.launch(context = Dispatchers.IO) {
            val quotes = repository.allQuotes()
            val authors = repository.allAuthors()

            quotesLiveData.postValue(quotes)
            authorsLiveData.postValue(authors)
        }
    }

    fun add(quote: QuoteV2) {
        GlobalScope.launch(context = Dispatchers.IO) {
            repository.add(quote)
            loadAuthorsAndQuotes()
        }
    }


    fun delete(quoteWithAuthor: QuoteWithAuthor) {
        GlobalScope.launch(context = Dispatchers.IO) {
            repository.delete(quoteWithAuthor.quote)
            loadAuthorsAndQuotes()
        }
    }
}