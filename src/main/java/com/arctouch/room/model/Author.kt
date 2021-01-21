package com.arctouch.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Author(
    @PrimaryKey(autoGenerate = true) val authorId: Long = 0,
    val name: String
) {

    override fun toString(): String {
        return name
    }
}




















//data class AuthorWithQuotes(
//    @Embedded val author: Author,
//    @Relation(
//        parentColumn = "authorId",
//        entityColumn = "authorId",
//    )
//    val quotes: List<QuoteV2>,
//)