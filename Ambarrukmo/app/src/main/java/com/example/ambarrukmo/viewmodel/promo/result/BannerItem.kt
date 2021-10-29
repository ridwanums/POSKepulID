package com.example.ambarrukmo.viewmodel.promo.result

import com.google.gson.annotations.SerializedName

data class BannerItem(
    val created_at: String,
    val created_by: Int,
    val deleted_at: String,
    val highlight_txt: String,
    val is_active: Int,
    val is_non_period: Int,
    val is_pasc_merchant: Int,
    val is_redeemable: Int,
    val is_static: Int,
    val merchant_promo: MerchantPromo,
    val merchants: List<Any>,
    val notice_txt: String,
    val promo_code: String,
    val promo_description: String,
    val promo_end_date: String,
    val promo_id: Int,
    val promo_image: String,
    val promo_image_url: String,
    val promo_media_type: Int,
    val promo_min_transaction: String,
    val promo_qty: Int,
    val promo_slug: String,
    val promo_start_date: String,
    val promo_title: String,
    val promo_video_thumbnail: String,
    val redeem_point: Int,
    val segment: Int,
    val updated_at: String,
    val updated_by: Int
)

class MerchantPromo