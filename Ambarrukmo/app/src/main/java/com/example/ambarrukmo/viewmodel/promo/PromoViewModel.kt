package com.example.ambarrukmo.viewmodel.promo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.ambarrukmo.api.ApiCallback
import com.example.ambarrukmo.api.ApiResult
import com.example.ambarrukmo.viewmodel.appconfig.walktrough.WalktroughItemList
import com.example.ambarrukmo.viewmodel.promo.result.*

class PromoViewModel  internal constructor(private val promoRepository: PromoRepository) : ViewModel(){
    fun getBannerData() : LiveData<ApiCallback<BannerItem>> = liveData(viewModelScope.coroutineContext) {
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = promoRepository.getBannerApi()){
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

    fun getPromoVoucherData(): LiveData<ApiCallback<Nothing>> = liveData(viewModelScope.coroutineContext) {
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = promoRepository.getPromoVoucherApi()){
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

    fun getPromotionData(): LiveData<ApiCallback<PromotionListItem>> = liveData(viewModelScope.coroutineContext) {
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = promoRepository.getPromotionListApi()){
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

    fun getDetailPromotionData(): LiveData<ApiCallback<DetailPromoListItem>> = liveData(viewModelScope.coroutineContext) {
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = promoRepository.getDetailPromotionListApi()){
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

    fun getPromotionCategoryData(): LiveData<ApiCallback<PromotionCategoryItem>> = liveData(viewModelScope.coroutineContext) {
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = promoRepository.getPromotionCateoryApi()){
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

    fun getPromotionEventData(): LiveData<ApiCallback<PromoEventItem>> = liveData(viewModelScope.coroutineContext) {
        emit(ApiCallback.OnLoading("Loading"))
        when(val callApi = promoRepository.getPromotionEventApi()){
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