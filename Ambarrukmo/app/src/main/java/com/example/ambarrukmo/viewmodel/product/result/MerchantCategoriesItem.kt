package com.example.ambarrukmo.viewmodel.product.result

class MerchantCategoriesItem : ArrayList<MerchantCategoriesItemItem>()

data class MerchantCategoriesItemItem(
    val cat_created_by: Int,
    val cat_description: String,
    val cat_id: Int,
    val cat_image: String,
    val cat_name: String,
    val cat_slug: String,
    val created_at: String,
    val deleted_at: String,
    val is_active: Int,
    val updated_at: String
)