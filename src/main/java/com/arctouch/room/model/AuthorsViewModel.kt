package com.arctouch.room.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AuthorsViewModel(private val repository: QuotesWithAuthorRepository) : ViewModel() {

    val authorsLiveData = MutableLiveData<List<Author>>()

    fun load() {
        GlobalScope.launch(Dispatchers.IO) {
            val authors = repository.allAuthors()
            authorsLiveData.postValue(authors)
        }
    }

    fun add(item: Author) {
        GlobalScope.launch(Dispatchers.IO) {
            repository.add(item)

            load()
        }
    }

    fun delete(author: Author) {
        GlobalScope.launch(Dispatchers.IO) {
            repository.delete(author)
            load()
        }
    }

}