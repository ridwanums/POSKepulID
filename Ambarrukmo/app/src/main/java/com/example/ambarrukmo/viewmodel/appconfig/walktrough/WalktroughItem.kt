package com.example.ambarrukmo.viewmodel.appconfig.walktrough

import com.google.gson.annotations.SerializedName
class WalktroughItemList : ArrayList<WalktroughItem>()

data class WalktroughItem(
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("is_active")
    val is_active: Int,
    @SerializedName("sort")
    val sort: Int,
    @SerializedName("updated_at")
    val updated_at: String,
    @SerializedName("walkthrough_content")
    val walkthrough_content: String,
    @SerializedName("walkthrough_id")
    val walkthrough_id: Int,
    @SerializedName("walkthrough_image")
    val walkthrough_image: String,
    @SerializedName("walkthrough_title")
    val walkthrough_title: String
)