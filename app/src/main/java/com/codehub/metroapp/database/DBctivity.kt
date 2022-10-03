package com.codehub.metroapp.database

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.codehub.metroapp.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DBctivity : AppCompatActivity() {
    private lateinit var database: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbctivity)

        database = Room.databaseBuilder(this, MyDatabase::class.java, "Myapplication").build()

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)


        GlobalScope.launch(Dispatchers.Default) {
            insertItem()

            getItems()
        }
    }

    suspend fun insertItem() {
        database.getUserDao().save(UserTable("vassilis", "", 100, true))
    }

    suspend fun getItems() {
        database.getUserDao().getAll().forEach {
            Log.d("APP", it.toString())
        }
    }
}