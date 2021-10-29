package com.example.ambarrukmo.viewmodel.promo.result

import androidx.annotation.Keep

@Keep
class PromotionListItem : ArrayList<PromotionListItemItem>()

@Keep
data class PromotionListItemItem(
    val created_at: String,
    val created_by: Int,
    val deleted_at: String,
    val highlight_txt: String,
    val images: List<Image>,
    val is_active: Int,
    val is_non_period: Int,
    val is_pasc_merchant: Int,
    val is_redeemable: Int,
    val is_static: Int,
    val merchant_promo: MerchantPromoItem,
    val merchants: List<Merchant>,
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

data class Image(
    val pr_img_filename: String,
    val pr_img_id: Int,
    val pr_img_promo_id: Int,
    val pr_img_type: Int,
    val pr_img_url: String
)

data class MerchantPromoItem (
    val created_at: String,
    val deleted_at: String,
    val floor_maps: List<FloorMap>,
    val is_active: Int,
    val is_hot: Int,
    val is_pasc: Int,
    val merchant_address: String,
    val merchant_created_by: Int,
    val merchant_description: String,
    val merchant_id: Int,
    val merchant_info: String,
    val merchant_location: String,
    val merchant_location_floor_txt: String,
    val merchant_logo: String,
    val merchant_name: String,
    val merchant_phone: String,
    val merchant_slug: String,
    val merchant_type: Int,
    val pasc_discount: String,
    val pasc_discount_txt: String,
    val updated_at: String
)

data class FloorMap(
    val created_at: String,
    val deleted_at: String,
    val floor_code: String,
    val floor_created_by: Int,
    val floor_description: String,
    val floor_id: Int,
    val floor_image: String,
    val floor_name: String,
    val floor_slug: String,
    val updated_at: String
)

data class Merchant(
    val created_at: String,
    val deleted_at: String,
    val floor_maps: List<FloorMapX>,
    val is_active: Int,
    val is_hot: Int,
    val is_pasc: Int,
    val merchant_address: String,
    val merchant_created_by: Int,
    val merchant_description: String,
    val merchant_id: Int,
    val merchant_info: String,
    val merchant_location: String,
    val merchant_location_floor_txt: String,
    val merchant_logo: String,
    val merchant_name: String,
    val merchant_phone: String,
    val merchant_slug: String,
    val merchant_type: Int,
    val pasc_discount: String,
    val pasc_discount_txt: String,
    val updated_at: String
)

data class FloorMapX(
    val created_at: String,
    val deleted_at: String,
    val floor_code: String,
    val floor_created_by: Int,
    val floor_description: String,
    val floor_id: Int,
    val floor_image: String,
    val floor_name: String,
    val floor_slug: String,
    val updated_at: String
)