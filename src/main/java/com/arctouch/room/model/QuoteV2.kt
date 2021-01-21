package com.arctouch.room.model

import androidx.room.*

@Entity(
    foreignKeys = [ForeignKey(
        entity = Author::class,
        parentColumns = arrayOf("authorId"),
        childColumns = arrayOf("authorId"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class QuoteV2(
    @PrimaryKey(autoGenerate = true) val quoteId: Long = 0,
    val text: String,
    val authorId: Long
)

data class QuoteWithAuthor(
    @Embedded val quote: QuoteV2,


    @Relation(
        parentColumn = "authorId",
        entityColumn = "authorId",
    )
    val author: Author,
)













//{
//    val authorName get() = author.name
//    val quoteText get() = quote.text
//}

