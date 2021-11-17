package com.example.ambarrukmo.viewmodel.product

import android.content.Intent
import com.example.ambarrukmo.api.ApiResponse
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.viewmodel.product.result.*
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductService {
    @GET("merchant/categories")
    suspend fun getMerchantCategories(): Response<ApiResponse<MerchantCategoriesItem?>?>

    @GET("merchants")
    suspend fun getMerchat() : Response<ApiResponse<MerchantListItem?>?>

    @POST("floors")
    suspend fun getFloor(@Body requestBody: RequestBody): Response<ApiResponse<LevelFloorItem?>?>

    @GET ("merchant/category/show/1")
    suspend fun getCategoryDining(): Response<ApiResponse<MerchantCategory?>?>

    @GET ("merchant/category/show/2")
    suspend fun getCategoryLifeStyle(): Response<ApiResponse<MerchantCategory?>?>

    @GET ("merchant/category/show/3")
    suspend fun getCategoryStyle(): Response<ApiResponse<MerchantCategory?>?>

    @GET ("merchant/category/show/4")
    suspend fun getCategoryBeauty(): Response<ApiResponse<MerchantCategory?>?>

    @GET ("merchant/category/show/5")
    suspend fun getCategoryHomeLiving(): Response<ApiResponse<MerchantCategory?>?>

    @GET ("merchant/category/show/6")
    suspend fun getCategoryKids(): Response<ApiResponse<MerchantCategory?>?>

    @GET("merchant/show/148")
    suspend fun getDetailMerchants() : Response<ApiResponse<DetailMerchantsItem?>?>
}