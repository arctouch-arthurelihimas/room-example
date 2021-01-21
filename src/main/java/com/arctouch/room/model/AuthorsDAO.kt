package com.arctouch.room.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AuthorsDAO {

    @Query("SELECT * FROM author")
    fun allAuthors(): List<Author>

    @Insert
    fun insertAuthor(quote: Author): Long

    @Delete
    fun delete(author: Author)
}