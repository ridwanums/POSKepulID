package com.example.ambarrukmo.viewmodel.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.ApiResult
import com.example.ambarrukmo.viewmodel.product.result.MerchantCategoriesItem
import com.example.ambarrukmo.viewmodel.product.result.MerchantListItem

class ProductViewModel internal constructor(private val productRepository: ProductRepository) : ViewModel() {
    fun getMerchantCategoriesData() : LiveData<ApiCallback<MerchantCategoriesItem>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getMerchantsCategoriesApi()){
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

    fun getMerchantData() : LiveData<ApiCallback<MerchantListItem>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getMerchantsApi()){
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