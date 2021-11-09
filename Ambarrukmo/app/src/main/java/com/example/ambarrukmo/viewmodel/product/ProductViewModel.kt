package com.example.ambarrukmo.viewmodel.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.ApiResult
import com.example.ambarrukmo.viewmodel.product.result.*
import com.example.ambarrukmo.viewmodel.promo.result.FloorMap
import okhttp3.RequestBody

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

    fun getLevelFloorData(requestBody: RequestBody) : LiveData<ApiCallback<LevelFloorItem>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getLevelFloorAPi(requestBody)){
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

    fun getCategoryDiningData() : LiveData<ApiCallback<MerchantCategory>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getCategoryDiningApi()){
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

    fun getCategoryLifeStyleData() : LiveData<ApiCallback<MerchantCategory>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getCategoryLifeStyleApi()){
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

    fun getCategoryStyleData() : LiveData<ApiCallback<MerchantCategory>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getCategoryStyleApi()){
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

    fun getCategoryBeautyData() : LiveData<ApiCallback<MerchantCategory>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getCategoryBeautyApi()){
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

    fun getCategoryHomeLivingData() : LiveData<ApiCallback<MerchantCategory>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getCategoryHomeLivingApi()){
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

    fun getCategoryKidsData() : LiveData<ApiCallback<MerchantCategory>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getCategoryKidsApi()){
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

    fun getDetailMerchantsData() : LiveData<ApiCallback<DetailMerchantsItem>> = liveData(viewModelScope.coroutineContext){
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = productRepository.getDetailMerchantsApi()){
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