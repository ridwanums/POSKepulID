package com.example.ambarrukmo.viewmodel.product

import com.example.ambarrukmo.api.ApiResponse
import com.example.ambarrukmo.viewmodel.product.result.MerchantCategoriesItem
import com.example.ambarrukmo.viewmodel.product.result.MerchantListItem
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("merchant/categories")
    suspend fun getMerchantCategories(): Response<ApiResponse<MerchantCategoriesItem?>?>

    @GET("merchants")
    suspend fun getMerchat() : Response<ApiResponse<MerchantListItem?>?>
}