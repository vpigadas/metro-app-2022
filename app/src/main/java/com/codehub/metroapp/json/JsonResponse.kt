package com.codehub.metroapp.json

import com.google.gson.JsonElement
import com.google.gson.JsonObject

data class JsonResponse<T : JsonTypes>(
    val type: String,
    val data: List<JsonObject>
){
    fun<T: JsonTypes> getDataPerType(): List<T>{
        return emptyList()
    }

    fun getDataPerType2(): List<JsonTypes>{
        return emptyList()
    }
}

interface JsonTypes

data class JsonDataResponse(
    val consumption: Double,
    val prediction: Double,
    val created_at: Long
): JsonTypes
