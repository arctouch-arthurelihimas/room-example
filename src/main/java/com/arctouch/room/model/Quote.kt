package com.arctouch.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//step 1 annotate entities
@Entity
data class Quote(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val text: String
) {
    constructor(text: String) : this(0, text)
}










