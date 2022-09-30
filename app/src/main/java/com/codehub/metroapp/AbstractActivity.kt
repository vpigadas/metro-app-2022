package com.codehub.metroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class AbstractActivity(layoutRes: Int) : AppCompatActivity(layoutRes) {
    abstract fun handleUI(): Unit

    abstract fun startOperation(): Unit

    abstract fun stopOperation(): Unit

    override fun onRestart() {
        super.onRestart()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        handleUI()
    }

    override fun onResume() {
        super.onResume()
        startOperation()
    }

    override fun onPostResume() {
        super.onPostResume()
    }

    override fun onPause() {
        stopOperation()
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}