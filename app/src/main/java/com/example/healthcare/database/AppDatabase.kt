package com.example.healthcare.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.healthcare.database.dao.DatabaseDao
import com.example.healthcare.model.ModelDatabase

@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}