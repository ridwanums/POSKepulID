package com.example.ambarrukmo.viewmodel.content

import com.example.ambarrukmo.api.ApiResponse
import com.example.ambarrukmo.viewmodel.content.result.Faq
import retrofit2.Response
import retrofit2.http.GET

interface ContentService {
    @GET("get_content")
    suspend fun getFaq () : Response<ApiResponse<Faq?>?>
}