package com.codehub.metroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_2)

        val preference = getPreferences(MODE_PRIVATE)
        val editor = preference.edit()
        editor.putString("action","")
        editor.putString("action","")
        editor.putString("action","")
        editor.putString("action","")
        editor.putString("action","")
        editor.commit()
        editor.apply()

        val shearedPreference = getSharedPreferences("", MODE_PRIVATE)
        shearedPreference.edit().apply()
    }
}