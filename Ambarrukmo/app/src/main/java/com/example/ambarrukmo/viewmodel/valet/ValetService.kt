package com.example.ambarrukmo.viewmodel.valet

import com.example.ambarrukmo.api.ApiResponse
import com.example.ambarrukmo.viewmodel.valet.result.ValetHistoryItem
import com.example.ambarrukmo.viewmodel.valet.result.ValetCreateItem
import com.example.ambarrukmo.viewmodel.valet.result.ValetNumberItem
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ValetService {
    @GET("vallet/get_number")
    suspend fun getNumberValet() : Response<ApiResponse<ValetNumberItem?>?>

    @POST("vallet/create")
    suspend fun getCreateValet(@Body requestBody: RequestBody) : Response<ApiResponse<ValetCreateItem?>?>

    @GET("vallet/history")
    suspend fun getHistoryValet(): Response<ApiResponse<ValetHistoryItem?>?>
}