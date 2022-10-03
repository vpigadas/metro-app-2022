package com.codehub.metroapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserTable::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getUserDao():UserDao
}

