package com.example.ambarrukmo.viewmodel.appconfig

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.ApiResult
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItem
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItemList

class AppConfigViewModel internal constructor(private val appConfigRepository: AppConfigRepository): ViewModel(){

    fun getWalktroughtData() : LiveData<ApiCallback<WalktroughItemList>> = liveData(viewModelScope.coroutineContext) {
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = appConfigRepository.getSWalktroughApi()){
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
}