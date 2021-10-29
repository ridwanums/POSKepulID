package com.example.ambarrukmo.viewmodel.auth

import com.example.ambarrukmo.api.ApiResponse
import com.example.ambarrukmo.viewmodel.auth.result.LoginItem
import com.example.ambarrukmo.viewmodel.auth.result.RegisterItem
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("register")
    suspend fun getRegister(@Body requestBody: RequestBody) : Response<ApiResponse<RegisterItem?>?>

    @POST("auth/login")
    suspend fun getLogin(@Body requestBody: RequestBody): Response<ApiResponse<LoginItem?>?>
}