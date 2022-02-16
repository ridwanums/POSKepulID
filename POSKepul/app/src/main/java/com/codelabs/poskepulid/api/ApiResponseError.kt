package com.example.ambarrukmo.api

import com.google.gson.annotations.SerializedName

data class ApiResponseError(
    @SerializedName("STATUS")
    val wtfStatus : Int,
    @SerializedName("MESSAGE")
    val wtfMessage: String
)