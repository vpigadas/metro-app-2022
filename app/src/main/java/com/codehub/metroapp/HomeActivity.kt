package com.codehub.metroapp

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codehub.metroapp.json.JsonDataResponse
import com.codehub.metroapp.json.JsonResponse
import com.google.gson.Gson

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val username = intent.getStringExtra("username")
        Log.d("HOME", username.toString())

        startActivity(Intent(this, OrderActivity::class.java))

        findViewById<Button>(R.id.home_finish).setOnClickListener {
            val intent = intent
            intent.putExtra("data", 1000)
            setResult(500, intent)
            finish()
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        if (getConnectivityStatus()) {
            makeACall()
        }

    }

    private fun makeACall() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://mobile-api.ensight.gr/api/device//C8C9A3705BFB/consumption/daily"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val json = Gson().fromJson<JsonResponse<JsonDataResponse>>(
                    response,
                    JsonResponse::class.java
                )
                findViewById<TextView>(R.id.home_text).text = response
            },
            Response.ErrorListener {
                it
            })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    override fun onBackPressed() {
        Log.d("HOME", "Back pressed")
        super.onBackPressed()
    }

    private fun getConnectivityStatus(): Boolean {
        var isConnected = false
        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            val network = connectivityManager.activeNetwork
            val connection = connectivityManager.getNetworkCapabilities(network)

            connection?.also {
                isConnected = it.hasTransport(NetworkCapabilities.TRANSPORT_VPN) ||
                        it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
            }
        } else {
            val activeNetwork = connectivityManager.activeNetworkInfo

            activeNetwork?.also {
                isConnected = it.type == ConnectivityManager.TYPE_WIFI ||
                        it.type == ConnectivityManager.TYPE_MOBILE ||
                        it.type == ConnectivityManager.TYPE_VPN
            }
        }
        return isConnected
    }
}