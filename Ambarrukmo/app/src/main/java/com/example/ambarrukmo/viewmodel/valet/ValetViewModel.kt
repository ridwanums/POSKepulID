package com.example.ambarrukmo.viewmodel.valet

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.ApiResult
import com.example.ambarrukmo.viewmodel.valet.result.ValetHistoryItem
import com.example.ambarrukmo.viewmodel.valet.result.ValetCreateItem
import com.example.ambarrukmo.viewmodel.valet.result.ValetNumberItem
import okhttp3.RequestBody

class ValetViewModel internal constructor(private val valetRepository: ValetRepository) : ViewModel(){
    fun getValetNumberData() : LiveData<ApiCallback<ValetNumberItem>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = valetRepository.getValetNumberApi()){
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

    fun getCreateValetData(requestBody: RequestBody) : LiveData<ApiCallback<ValetCreateItem>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = valetRepository.getCreateValetApi(requestBody)){
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

    fun getValetHistoryData() : LiveData<ApiCallback<ValetHistoryItem>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = valetRepository.getValetHistoryApi()){
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