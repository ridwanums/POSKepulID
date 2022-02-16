package com.codelabs.poskepulid.api

import android.util.Base64
import com.codelabs.poskepulid.BuildConfig
import com.codelabs.poskepulid.api.HttpLoggingInterceptor
import com.google.gson.*
import okhttp3.*
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.UnsupportedEncodingException
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit


object RetrofitFactory {

    private val authInterceptor = Interceptor {
        val original = it.request()
        val newRequest = original.newBuilder()
            .header("Content-Type", AppConstant.contentype)
            .method(original.method, original.body)
        if (DataManager.getInstance().isLogin == true){
            val token = "Bearer"
            newRequest.addHeader("Authorization", token)
        }

       /* if(!DataManager.getInstance().authToken.isNullOrEmpty()){
            newRequest.addHeader("token", DataManager.getInstance().authToken ?: "")
        }*/

       /* if(!DataManager.getInstance().userToken.isNullOrEmpty()){
            newRequest.addHeader("user-token", DataManager.getInstance().userToken ?: "")
        }*/

        it.proceed(newRequest.build())
    }


    private val xenditInterceptor = Interceptor {
        //val encodedKey = encodeBase64(AppConstants.xenditClientKey + ":")
        val encodedKey = encodeBase64("AppConstants.xenditClientKey" + ":")
        val basicAuthCredentials = "Basic $encodedKey"

        val original = it.request()
        val newRequest = original.newBuilder()
            .header("Authorization", basicAuthCredentials)
            .header("x-client-identifier", "Xendit Android SDK")
            .header("is_single_use", "true")
            .header("should_authenticate", "true")
            .method(original.method, original.body)

        it.proceed(newRequest.build())
    }

  /*  private val languageInterceptor = Interceptor {
        val original = it.request()
        val body = original.body
        val subType = body?.contentType()?.subtype.toString()

        val newRequest:Request.Builder
        if(body != null){
            when{
                subType.contains("json")->{
                    newRequest = original.newBuilder().method(original.method, RequestBody.create(body.contentType(), body.bodyToJson()))
                }
                else -> {
                    newRequest = original.newBuilder().method(original.method, RequestBody.create(body.contentType(), body.bodyToForm()))
                }
            }
        }else{
            newRequest = original.newBuilder().url(original.url.newBuilder().addQueryParameter("Language",DataManager.getInstance().languageId).build())
        }
        it.proceed(newRequest.build())
    }*/

    private fun RequestBody?.bodyToString(): String {
        if (this == null) return ""
        val buffer = okio.Buffer()
        writeTo(buffer)
        return buffer.readUtf8()
    }

    private fun RequestBody?.bodyToJson(): String {
        if (this == null) return ""
        val json = JSONObject(this.bodyToString())
        json.put("Language",DataManager.getInstance().languageId)
        return json.toString()
    }

    private fun RequestBody?.bodyToForm(): String {
        if (this == null) return ""
        val param = this.bodyToString().plus("&Language="+DataManager.getInstance().languageId)
        return param
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    //Not logging the authkey if not debug
    private fun client(isXendit: Boolean? = false, isLanguage: Boolean? = false): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .readTimeout(120, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)

        if(isLanguage == true)
           // builder.addInterceptor(languageInterceptor)

        if(isXendit == true)
            builder.addInterceptor(xenditInterceptor)
        else
            builder.addInterceptor(authInterceptor)

        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(loggingInterceptor)
        }

        return builder.build()
    }

    class DoubleGsonTypeAdapter : JsonDeserializer<Double?> {
        @Throws(JsonParseException::class)
        override fun deserialize(
            jsonElement: JsonElement,
            type: Type?,
            jsonDeserializationContext: JsonDeserializationContext?
        ): Double? {
            var result: Double? = null
            result = try {
                jsonElement.asDouble
            } catch (e: NumberFormatException) {
                return result
            }
            return result
        }
    }

    class IntGsonTypeAdapter : JsonDeserializer<Int?> {
        @Throws(JsonParseException::class)
        override fun deserialize(
            jsonElement: JsonElement,
            type: Type?,
            jsonDeserializationContext: JsonDeserializationContext?
        ): Int? {
            var result: Int? = null
            result = try {
                jsonElement.asInt
            } catch (e: NumberFormatException) {
                return result
            }
            return result
        }
    }

    private fun gsonConfig(): Gson {

        return GsonBuilder()
            .registerTypeAdapter(java.lang.Double::class.java, DoubleGsonTypeAdapter())
            .registerTypeAdapter(Double::class.java, DoubleGsonTypeAdapter())
            .registerTypeAdapter(java.lang.Integer::class.java, IntGsonTypeAdapter())
            .registerTypeAdapter(Int::class.java, IntGsonTypeAdapter())
            .create()
    }

    fun retrofit(url:String, isXendit:Boolean? = false): Retrofit {
        return Retrofit.Builder()
            .client(client(isXendit,true))
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gsonConfig()))
            .build()
    }

    fun retrofit2(url:String, isXendit:Boolean? = false): Retrofit {
        return Retrofit.Builder()
            .client(client(isXendit,false))
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gsonConfig()))
            .build()
    }


    //xendit test

    private fun encodeBase64(key: String): String? {
        try {
            val keyData = key.toByteArray(charset("UTF-8"))
            return Base64.encodeToString(keyData, Base64.NO_WRAP)
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        return null
    }

}