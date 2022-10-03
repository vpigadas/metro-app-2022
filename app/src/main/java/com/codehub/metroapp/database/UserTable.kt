package com.codehub.metroapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "user", primaryKeys = ["username"])
data class UserTable(
    @ColumnInfo(name = "username") val name: String,
    @ColumnInfo(name = "address") val address: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "isMale") val isMale: Boolean
)