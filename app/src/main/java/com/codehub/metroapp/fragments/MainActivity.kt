package com.codehub.metroapp.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codehub.metroapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        supportFragmentManager.beginTransaction().also {
            it.replace(R.id.frame1, BlankFragment(), "BlankFragment")
            it.addToBackStack(null)
        }.commit()


    }
}