package com.codehub.metroapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(R.layout.activity_login2) {

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        findViewById<Button>(R.id.login_btn_login).setOnClickListener {
            userValidate().also {
                Log.d("APP", it.toString())

                if (it != null) {
                    val intent = Intent(this, HomeActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString("username", it)

                    intent.putExtras(bundle)
                    startActivityForResult(intent, 9000)
                }
            }


            val result = userValidate()
            Log.d("APP", result.toString())
        }
        val btnCancel = findViewById<Button>(R.id.login_cancel)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("RESULT", "request code -> $requestCode, result code $resultCode, has data ${data?.extras?.size()}")
    }

    private fun userValidate(): String? {
        val editUsername = findViewById<EditText>(R.id.login_edit_username_value)
        val editPassword = findViewById<EditText>(R.id.login_edit_password_value)

        val username = editUsername.text.toString()
        val password = editPassword.text.toString()

        return when (username == "a" && password == "1") {
            true -> username
            false -> null
        }
    }
}