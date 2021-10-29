package com.example.ambarrukmo.viewmodel.promo

import com.example.ambarrukmo.api.*
import com.example.ambarrukmo.viewmodel.promo.result.*

class PromoRepository private constructor() : BaseRepository(){

    suspend fun getBannerApi() : ApiResult<ApiResponse<BannerItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(PromoService::class.java).getBanner()}
        )
    }

    suspend fun getPromoVoucherApi() : ApiResult<ApiResponse<Nothing?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(PromoService::class.java).getPromoVoucher()}
        )
    }

    suspend fun getPromotionListApi() : ApiResult<ApiResponse<PromotionListItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(PromoService::class.java).getPromotionList()}
        )
    }

    suspend fun getDetailPromotionListApi() : ApiResult<ApiResponse<DetailPromoListItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(PromoService::class.java).getDetailPromoList()}
        )
    }


    suspend fun getPromotionCateoryApi() : ApiResult<ApiResponse<PromotionCategoryItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(PromoService::class.java).getPromotionCategory()}
        )
    }

    suspend fun getPromotionEventApi() : ApiResult<ApiResponse<PromoEventItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(PromoService::class.java).getPromotionEvent()}
        )
    }

    companion object{
        @Volatile private var instance: PromoRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: PromoRepository().also { instance = it }
            }
    }
}