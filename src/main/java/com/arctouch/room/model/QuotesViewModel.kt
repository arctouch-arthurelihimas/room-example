package com.arctouch.room.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class QuotesViewModel(private val quotesRepository: QuotesRepository) : ViewModel() {


    fun loadQuotes() = quotesRepository.getQuotes()

    fun addItem(item: Quote) {
        //don't use Room on the main thread
        GlobalScope.launch(context = Dispatchers.IO) {
            quotesRepository.add(item)
        }
    }

}