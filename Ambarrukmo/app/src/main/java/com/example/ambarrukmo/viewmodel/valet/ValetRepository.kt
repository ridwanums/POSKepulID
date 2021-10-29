package com.example.ambarrukmo.viewmodel.valet

import com.example.ambarrukmo.api.*
import com.example.ambarrukmo.viewmodel.valet.result.ValetHistoryItem
import com.example.ambarrukmo.viewmodel.valet.result.ValetCreateItem
import com.example.ambarrukmo.viewmodel.valet.result.ValetNumberItem
import okhttp3.RequestBody

class ValetRepository private constructor(): BaseRepository(){

    suspend fun getValetNumberApi() : ApiResult<ApiResponse<ValetNumberItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ValetService::class.java).getNumberValet()}
        )
    }

    suspend fun getCreateValetApi(requestBody: RequestBody) : ApiResult<ApiResponse<ValetCreateItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ValetService::class.java).getCreateValet(requestBody)}
        )
    }

    suspend fun getValetHistoryApi() : ApiResult<ApiResponse<ValetHistoryItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ValetService::class.java).getHistoryValet()}
        )
    }

    companion object{
        @Volatile private var instance: ValetRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: ValetRepository().also { instance = it }
            }
    }
}