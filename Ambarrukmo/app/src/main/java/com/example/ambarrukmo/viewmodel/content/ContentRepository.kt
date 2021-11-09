package com.example.ambarrukmo.viewmodel.content

import com.example.ambarrukmo.api.*
import com.example.ambarrukmo.viewmodel.content.result.Faq

class ContentRepository private constructor(): BaseRepository() {

    suspend fun getFaqApi() : ApiResult<ApiResponse<Faq?>?> {
        return safeApiCall (call =
        { RetrofitFactory.retrofit(AppConstants.urlMaster).create(ContentService::class.java).getFaq()}
        )
    }

    companion object{
        @Volatile private var instance: ContentRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance
                    ?: ContentRepository().also { instance = it }
            }
    }
}