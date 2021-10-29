package com.example.ambarrukmo.viewmodel.product

import com.example.ambarrukmo.api.*
import com.example.ambarrukmo.viewmodel.product.result.MerchantCategoriesItem
import com.example.ambarrukmo.viewmodel.product.result.MerchantListItem
import com.example.ambarrukmo.viewmodel.valet.ValetService

class ProductRepository private constructor(): BaseRepository(){


    suspend fun getMerchantsCategoriesApi() : ApiResult<ApiResponse<MerchantCategoriesItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getMerchantCategories()}
        )
    }

    suspend fun getMerchantsApi() : ApiResult<ApiResponse<MerchantListItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getMerchat()}
        )
    }

    companion object{
        @Volatile private var instance: ProductRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: ProductRepository().also { instance = it }
            }
    }
}