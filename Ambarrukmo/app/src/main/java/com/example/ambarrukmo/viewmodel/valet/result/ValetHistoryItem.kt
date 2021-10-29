package com.example.ambarrukmo.viewmodel.valet.result

class ValetHistoryItem : ArrayList<ValetHistoryItemItem>()

data class ValetHistoryItemItem(
    val canceled_by: Int,
    val car_brand: String,
    val car_color: String,
    val car_type: String,
    val completed_by: Int,
    val created_at: String,
    val no_pol: String,
    val parking_date_in: String,
    val parking_date_out: String,
    val status: Int,
    val status_txt: String,
    val time_abbr: String,
    val time_limit: String,
    val updated_at: String,
    val user_id: Int,
    val vallet_code: String,
    val vallet_number: String,
    val vb_id: Int,
    val verified_by: Int
)