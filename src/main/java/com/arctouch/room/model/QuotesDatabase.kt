package com.arctouch.room.model

import androidx.room.Database
import androidx.room.RoomDatabase

//step 3 create database
@Database(entities = [Quote::class], version = 1)
abstract class QuotesDatabase : RoomDatabase() {

    abstract fun quotesDAO(): QuotesDAO

}