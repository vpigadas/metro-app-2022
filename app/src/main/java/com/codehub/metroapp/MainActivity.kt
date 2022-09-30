package com.codehub.metroapp

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AbstractActivity(R.layout.activity_login), View.OnClickListener {

    override fun handleUI() {
        val textView = findViewById<TextView>(R.id.login_title)
        textView.setText("User!!!")
        //TODO("Not yet implemented")
        textView.setOnClickListener(this)

        findViewById<Button>(R.id.login_btn_login).setOnClickListener {
           loginAction(it)
        }
    }

    private fun loginAction(view:View) {
        Snackbar.make(view, "Login Button clicked!!!", Snackbar.LENGTH_LONG).show()
        Log.d("APP", "Login Button clicked!!!")
    }

    override fun startOperation() {
        //TODO("Not yet implemented")
    }

    override fun stopOperation() {
        //TODO("Not yet implemented")
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.login_title ->  Log.d("APP", "Title clicked!!!")
        }
    }
}
