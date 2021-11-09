package com.example.ambarrukmo.viewmodel.product.result

data class DetailMerchantsItem(
    val categories: List<CategoryDetail>,
    val created_at: String,
    val deleted_at: String,
    val floor_maps: List<FloorMapDetail>,
    val images: List<ImageDetail>,
    val is_active: Int,
    val is_hot: Int,
    val is_pasc: Int,
    val locations: List<LocationDetail>,
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
    val promotions: List<Any>,
    val rating_txt: String,
    val testimonials: List<TestimonialDetail>,
    val total_promo: Int,
    val total_rating: String,
    val total_rating_stars: Int,
    val updated_at: String
)

data class CategoryDetail(
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

data class FloorMapDetail(
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

data class ImageDetail(
    val created_at: String,
    val mc_image_filename: String,
    val mc_image_id: Int,
    val mc_image_merchant_id: Int,
    val updated_at: String
)

data class LocationDetail(
    val created_at: String,
    val deleted_at: String,
    val floor_code: String,
    val floor_created_by: Int,
    val floor_description: String,
    val floor_id: Int,
    val floor_image: String,
    val floor_name: String,
    val floor_slug: String,
    val location_code: String,
    val updated_at: String
)

data class TestimonialDetail(
    val fullname: String,
    val testimonial: String
)