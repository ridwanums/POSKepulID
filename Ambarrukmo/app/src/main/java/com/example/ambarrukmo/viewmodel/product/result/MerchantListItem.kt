package com.example.ambarrukmo.viewmodel.product.result

class MerchantListItem : ArrayList<MerchantListItemItem>()

data class MerchantListItemItem(
    val created_at: String,
    val deleted_at: String,
    val floor_maps: List<FloorMapMerchants>,
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

data class FloorMapMerchants(
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
