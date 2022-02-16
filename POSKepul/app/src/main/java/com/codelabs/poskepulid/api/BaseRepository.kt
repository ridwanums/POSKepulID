package com.codelabs.poskepulid.api

import com.example.ambarrukmo.api.ApiResponseError
import com.example.ambarrukmo.api.ApiResult
import com.google.gson.Gson
import retrofit2.Response
import java.io.IOException


open class BaseRepository{

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T?>): ApiResult<T?> {
        return safeApiResult(call)
    }

    private suspend fun <T: Any> safeApiResult(call: suspend ()-> Response<T?>) : ApiResult<T?> {
        return try {
            val response = call.invoke()
            if (response.isSuccessful) {
                ApiResult.Success(response.body())
            }else {
                handleResponseCode(response)
            }
        }catch (e:Throwable) {

            e.printStackTrace()
        //    FirebaseCrashlytics.getInstance().recordException(e)

            if (!e.message.isNullOrEmpty()) {

                when (e.cause) {
                    is IOException -> {

                        val msg:String = if(DataManager.getInstance().languageId == "ID"){
                            "Tidak ada internet, periksa jaringan anda"
                        }else{
                            "No internet available, please check network connection"
                        }

                        ApiResult.Error(msg, 555)
                    }
                    is IllegalStateException -> {

                        val msg:String = if(DataManager.getInstance().languageId == "ID"){
                            "Hasil tidak sesuai format ${e.message}"
                        }else{
                            "Response is not valid format ${e.message}"
                        }

                        ApiResult.Error(msg, 666)
                    }
                    else -> {

                        val msg:String = if(DataManager.getInstance().languageId == "ID"){
                            "Kesalahan ${e.message}"
                        }else{
                            "Error ${e.message}"
                        }

                        ApiResult.Error(msg, 777)
                    }
                }
            }else{
                val msg:String = if(DataManager.getInstance().languageId == "ID"){
                    "Kesalahan tidak di ketahui ${e.cause}"
                }else{
                    "Unknown Error ${e.cause}"
                }
                ApiResult.Error(msg, 888)
            }
        }
    }

    private fun <T: Any> handleResponseCode(response: Response<T?>): ApiResult<T?> {
        return when (response.code()) {
            404 -> {
                val msg:String = if(DataManager.getInstance().languageId == "ID"){
                    "Terjadi kesalah dalam pengambilan data 404"
                }else{
                    "An error occurred on getting data 404"
                }

                ApiResult.Error(
                    msg,
                    404
                )
            }
            500 -> {
                val msg:String = if(DataManager.getInstance().languageId == "ID"){
                    "Terjadi kesalah pada server 500"
                }else{
                    "An error occurred on server 500"
                }
                ApiResult.Error(
                    msg,
                    500
                )
            }
            else -> {
                val errorBody = response.errorBody()
                if(errorBody != null) {
                    val errorResponse =
                        Gson().fromJson(errorBody.string(), ApiResponseError::class.java)

                    ApiResult.Error(
                        errorResponse.wtfMessage,
                        response.code()
                    )
                }else{

                    val msg:String = if(DataManager.getInstance().languageId == "ID"){
                        "Terjadi kesalah tidak di ketahui"
                    }else{
                        "An error occurred unknown"
                    }
                    ApiResult.Error(
                        msg,
                        response.code()
                    )
                }
            }
        }
    }
}