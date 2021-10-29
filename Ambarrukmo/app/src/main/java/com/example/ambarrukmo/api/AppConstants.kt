package com.example.ambarrukmo.api

import com.example.ambarrukmo.BuildConfig
import java.util.*

object AppConstants{
    //auth
   /* private const val hostAuth: String = BuildConfig.HOST_AUTH
    private const val gatewayAuth: String = BuildConfig.HOST_AUTH_API
    const val urlAuth: String = "$hostAuth/$gatewayAuth/"
    const val userAuth = BuildConfig.AUTH_USER
    const val secretAuth = BuildConfig.AUTH_SECRET
    const val versionAuth = BuildConfig.AUTH_VERSION*/

    const val contentType: String = BuildConfig.CONTENT_TYPE


    //gateway
    private const val hostGateway: String = BuildConfig.HOST_GATEWAY
    private const val gatewayMaster: String = BuildConfig.HOST_GATEWAY_API
    private const val apiVersion: String = BuildConfig.AUTH_VERSION
    const val urlMaster: String = "$hostGateway/$apiVersion/"

    const val urlMember: String = "$hostGateway/"

    const val urlProduct: String = "$hostGateway/$gatewayMaster/$apiVersion/"

    const val DATE_FORMAT_EVENT = "dd MMM yyyy HH:mm"
    const val DATE_FORMAT_EVENT_DETAIL = "yyyy-MM-dd hh:mm:ss"
    const val DATE_FORMAT_EVENT_SCHEDULE = "dd-MM-yyyy"
    const val DATE_FORMAT_EVENT_TIME = "HH:mm:ss"
    const val DATE_FORMAT_DAY_DATE_MONTH_YEAR = "EEE dd MMM yyyy"
    const val DATE_FORMAT_HOUR = "HH:mm"
    const val DATE_FORMAT_HOUR_2= "hh:mm aaa"
    var locale = Locale.US

    //notification field
    const val notifyDataType:String="Type"
    const val notifyDataToken:String="Token"
    const val notifyDataId:String="Id"
    const val notifyDataTopic:String="Topic"
    const val notifyDataImage:String="Image"
    const val notifyDataTitle:String="Title"
    const val notifyDataBody:String="Body"
    const val notifyIsBackground:String="IsBackground"
}