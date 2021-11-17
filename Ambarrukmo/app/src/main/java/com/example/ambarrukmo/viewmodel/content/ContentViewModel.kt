package com.example.ambarrukmo.viewmodel.content

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.ApiResult
import com.example.ambarrukmo.viewmodel.content.result.ContentItem
import com.example.ambarrukmo.viewmodel.content.result.Faq

class ContentViewModel internal constructor(private val contentRepository: ContentRepository) : ViewModel() {
    fun getFaqData() : LiveData<ApiCallback<ContentItem>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = contentRepository.getFaqApi()){
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