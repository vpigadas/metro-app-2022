package com.codehub.metroapp.database

import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(data: UserTable)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(data: List<UserTable>)

    @Insert
    fun insert(data: UserTable)

    @Update
    fun update(data: UserTable)

    @Delete
    fun delete(data: UserTable)

    @Delete
    fun delete(data: List<UserTable>)

    @Query("SELECT * FROM user")
    fun getAll(): List<UserTable>

    @Query("SELECT * FROM user WHERE username LIKE :name")
    fun get(name: String): List<UserTable>

    @Query("SELECT * FROM user LIMIT 1")
    fun getFirst(): UserTable?

}