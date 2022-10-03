package com.codehub.metroapp.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codehub.metroapp.databinding.ActivityRecycler2Binding
import com.codehub.metroapp.json.JsonDataResponse
import com.codehub.metroapp.json.JsonResponse
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

class RecyclerActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityRecycler2Binding
    private val adapter: RecyclerListAdapter = RecyclerListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycler2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private var isRunning : Boolean = false

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        binding.recyclerFab.setOnClickListener {
            Snackbar.make(it, "Clicked!!!", Snackbar.LENGTH_LONG).show()
        }

        binding.recyclerView.adapter =
            RecyclerAdapter(listOf("A", "B", "C", "D"), object : RecyclerAdapter.OnClick {
                override fun onClick(data: String) {
                    if(isRunning == false){
                        isRunning = true
                        //operation
                        isRunning = false
                    }else{
                        Unit
                    }
                    TODO("Not yet implemented")
                }
            })
        binding.recyclerView.adapter = adapter
    }

    override fun onPostResume() {
        super.onPostResume()
        makeACall()
    }

    private fun makeACall() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://mobile-api.ensight.gr/api/device/C8C9A3705BFB/consumption/daily"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val json = Gson().fromJson<JsonResponse<JsonDataResponse>>(
                    response,
                    JsonResponse::class.java
                )
                adapter.submitList(
                    json.getDataPerType<JsonDataResponse>().map { it.consumption.toString() })
            },
            Response.ErrorListener {
                it
            })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}