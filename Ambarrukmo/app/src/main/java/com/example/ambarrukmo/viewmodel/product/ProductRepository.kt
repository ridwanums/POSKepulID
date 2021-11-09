package com.example.ambarrukmo.viewmodel.product

import com.example.ambarrukmo.api.*
import com.example.ambarrukmo.viewmodel.product.result.*
import com.example.ambarrukmo.viewmodel.valet.ValetService
import okhttp3.RequestBody

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

    suspend fun getLevelFloorAPi(requestBody: RequestBody) : ApiResult<ApiResponse<LevelFloorItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getFloor(requestBody)}
        )
    }

    suspend fun getCategoryDiningApi() : ApiResult<ApiResponse<MerchantCategory?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getCategoryDining()}
        )
    }

    suspend fun getCategoryLifeStyleApi() : ApiResult<ApiResponse<MerchantCategory?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getCategoryLifeStyle()}
        )
    }

    suspend fun getCategoryStyleApi() : ApiResult<ApiResponse<MerchantCategory?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getCategoryStyle()}
        )
    }
    suspend fun getCategoryBeautyApi() : ApiResult<ApiResponse<MerchantCategory?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getCategoryBeauty()}
        )
    }

    suspend fun getCategoryHomeLivingApi() : ApiResult<ApiResponse<MerchantCategory?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getCategoryHomeLiving()}
        )
    }

    suspend fun getCategoryKidsApi() : ApiResult<ApiResponse<MerchantCategory?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getCategoryKids()}
        )
    }

    suspend fun getDetailMerchantsApi() : ApiResult<ApiResponse<DetailMerchantsItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ProductService::class.java).getDetailMerchants()}
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