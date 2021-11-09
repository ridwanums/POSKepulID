package com.example.ambarrukmo.viewmodel.auth

import com.example.ambarrukmo.api.*
import com.example.ambarrukmo.viewmodel.appconfig.AppConfigService
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItemList
import com.example.ambarrukmo.viewmodel.auth.result.AuthenticateUserItem
import com.example.ambarrukmo.viewmodel.auth.result.CardUseInfoItem
import com.example.ambarrukmo.viewmodel.auth.result.LoginItem
import com.example.ambarrukmo.viewmodel.auth.result.RegisterItem
import okhttp3.RequestBody

class AuthRepository private constructor(): BaseRepository(){

    suspend fun getRegisterApi(requestBody: RequestBody) : ApiResult<ApiResponse<RegisterItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(AuthService::class.java).getRegister(requestBody)}
        )
    }

    suspend fun getLoginApi(requestBody: RequestBody) : ApiResult<ApiResponse<LoginItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(AuthService::class.java).getLogin(requestBody)}
        )
    }

    suspend fun getAuthenticeUserApi() : ApiResult<ApiResponse<AuthenticateUserItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(AuthService::class.java).getAuthenticeUser()}
        )
    }

    suspend fun getCardInfoApi() : ApiResult<ApiResponse<CardUseInfoItem?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(AuthService::class.java).getCardInfo()}
        )
    }

    companion object{
        @Volatile private var instance: AuthRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: AuthRepository().also { instance = it }
            }
    }
}