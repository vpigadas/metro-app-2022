package com.codehub.metroapp.mvvm

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codehub.metroapp.json.JsonDataResponse
import com.codehub.metroapp.json.JsonResponse
import com.google.gson.Gson

class ApiManager {

    interface OnResult {
        fun onSuccess(data: String)
        fun onFailed(error: Exception)
    }

    suspend fun makeACall(context: Context, results: OnResult) {

        val queue = Volley.newRequestQueue(context)
        val url = "https://mobile-api.ensight.gr/api/device/C8C9A3705BFB/consumption/daily"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val json = Gson().fromJson<JsonResponse<JsonDataResponse>>(
                    response,
                    JsonResponse::class.java
                )
                results.onSuccess(response)
            },
            Response.ErrorListener {
                results.onFailed(it)
            })

        queue.add(stringRequest)
    }
}