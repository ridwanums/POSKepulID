package com.example.ambarrukmo.viewmodel.auth

import com.example.ambarrukmo.api.ApiResponse
import com.example.ambarrukmo.viewmodel.auth.result.*
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @POST("register")
    suspend fun getRegister(@Body requestBody: RequestBody) : Response<ApiResponse<RegisterItem?>?>

    @POST("auth/login")
    suspend fun getLogin(@Body requestBody: RequestBody): Response<ApiResponse<LoginItem?>?>

    @GET("me")
    suspend fun getAuthenticeUser(): Response<ApiResponse<AuthenticateUserItem?>?>

    @GET("card_info")
    suspend fun getCardInfo(): Response<ApiResponse<CardUseInfoItem?>?>

    @POST("update_profile")
    suspend fun getUpdateProfile(@Body requestBody: RequestBody): Response<ApiResponse<UpdateProfileItem?>?>
}