package com.example.ambarrukmo.viewmodel.promo

import com.example.ambarrukmo.api.ApiResponse
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.viewmodel.promo.result.*
import retrofit2.Response
import retrofit2.http.GET

interface PromoService {
    @GET("promotion/get_static_banner")
    suspend fun getBanner(): Response<ApiResponse<BannerItem?>?>

    @GET("promotion/vouchers")
    suspend fun getPromoVoucher(): Response<ApiResponse<Nothing?>?>

    @GET("promotions")
    suspend fun getPromotionList(): Response<ApiResponse<PromotionListItem?>?>

    @GET("promotion/show/")
    suspend fun getDetailPromoList(): Response<ApiResponse<DetailPromoListItem?>?>

    @GET ("promotion/categories")
    suspend fun getPromotionCategory(): Response<ApiResponse<PromotionCategoryItem?>?>

    @GET("promotion/events")
    suspend fun getPromotionEvent(): Response<ApiResponse<PromoEventItem?>?>
}
