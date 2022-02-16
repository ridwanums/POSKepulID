package com.example.ambarrukmo.api

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("STATUS")
    val Status: Int,
    @SerializedName("MESSAGE")
    val Message: String,
    @SerializedName("DATA")
    var data: T?
)