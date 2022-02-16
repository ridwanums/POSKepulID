package com.example.ambarrukmo.api

sealed class ApiCallback<out T:Any>{
    class OnLoading(val message: String? = null) : ApiCallback<Nothing>()
    class OnSuccess<out T: Any>(val data : T? = null, val message: String? = null) : ApiCallback<T>()
    class OnError(val status: Int? = null, val message : String? = null) : ApiCallback<Nothing>()
}