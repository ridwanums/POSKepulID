package com.example.ambarrukmo.viewmodel.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.ApiResult
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.viewmodel.appconfig.AppConfigRepository
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItemList
import com.example.ambarrukmo.viewmodel.auth.result.LoginItem
import com.example.ambarrukmo.viewmodel.auth.result.RegisterItem
import okhttp3.RequestBody

class AuthViewModel internal constructor(private val authRepository: AuthRepository): ViewModel(){

    fun getRegisterData(requestBody: RequestBody) : LiveData<ApiCallback<RegisterItem>> = liveData(viewModelScope.coroutineContext) {
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = authRepository.getRegisterApi(requestBody)){
            is ApiResult.Success -> {
                if (callApi.data?.Status == 200){
                    emit(ApiCallback.OnSuccess(callApi.data.data, callApi.data.Message))
                } else {
                    emit(ApiCallback.OnError(callApi.data?.Status, callApi.data?.Message))
                }
            }
            is ApiResult.Error ->{
                emit(ApiCallback.OnError(callApi.status, callApi.message))
            }
        }
    }

    fun getLoginData(requestBody: RequestBody) : LiveData<ApiCallback<LoginItem>> = liveData(viewModelScope.coroutineContext) {
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = authRepository.getLoginApi(requestBody)){
            is ApiResult.Success -> {
                if (callApi.data?.Status == 200){
                    DataManager.getInstance().isLogin = true
                    DataManager.getInstance().userToken = callApi.data.data?.token
                    emit(ApiCallback.OnSuccess(callApi.data.data, callApi.data.Message))
                } else {
                    emit(ApiCallback.OnError(callApi.data?.Status, callApi.data?.Message))
                }
            }
            is ApiResult.Error ->{
                emit(ApiCallback.OnError(callApi.status, callApi.message))
            }
        }
    }
}