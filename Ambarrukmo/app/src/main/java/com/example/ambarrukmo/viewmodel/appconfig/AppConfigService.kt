package com.example.ambarrukmo.viewmodel.appconfig

import com.example.ambarrukmo.api.ApiResponse
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItemList
import retrofit2.Response
import retrofit2.http.GET

interface AppConfigService {
    @GET ("app/walkthrough")
    suspend fun getSWalktrough():Response<ApiResponse<WalktroughItemList?>?>
}