package com.example.ambarrukmo.viewmodel.product.result

data class MerchantCategory(
    val cat_created_by: Int,
    val cat_description: String,
    val cat_id: Int,
    val cat_image: String,
    val cat_name: String,
    val cat_slug: String,
    val created_at: String,
    val deleted_at: String,
    val is_active: Int,
    val merchants: List<Merchant>,
    val updated_at: String
)

data class Merchant(
    val created_at: String,
    val deleted_at: String,
    val floor_maps: List<FloorMap>,
    val images: List<Image>,
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

data class Image(
    val created_at: String,
    val mc_image_filename: String,
    val mc_image_id: Int,
    val mc_image_merchant_id: Int,
    val updated_at: String
)