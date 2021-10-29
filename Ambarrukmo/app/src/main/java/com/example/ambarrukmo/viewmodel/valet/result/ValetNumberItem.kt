package com.example.ambarrukmo.viewmodel.valet.result

data class ValetNumberItem(
    val created_at: String,
    val total_booked: Int,
    val total_slot: String,
    val updated_at: String,
    val user_id: Int,
    val vallet_number: String,
    val vb_temp_id: Int
)