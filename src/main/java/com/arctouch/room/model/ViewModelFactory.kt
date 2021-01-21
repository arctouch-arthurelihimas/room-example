package com.arctouch.room.model

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuotesViewModel::class.java)) {
            return QuotesViewModel(QuotesRepository(context)) as T
        }
        if (modelClass.isAssignableFrom(QuotesWithAuthorsViewModel::class.java)) {
            return QuotesWithAuthorsViewModel(QuotesWithAuthorRepository(context)) as T
        }

        return AuthorsViewModel(QuotesWithAuthorRepository(context)) as T
    }

}