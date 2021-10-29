package com.example.ambarrukmo.viewmodel.appconfig


import com.example.ambarrukmo.api.*
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItem
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItemList

class AppConfigRepository private constructor(): BaseRepository(){
    suspend fun getSWalktroughApi() : ApiResult<ApiResponse<WalktroughItemList?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(AppConfigService::class.java).getSWalktrough()}
        )
    }

    companion object{
        @Volatile private var instance: AppConfigRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: AppConfigRepository().also { instance = it }
            }
    }
}