package com.codelabs.poskepulid.api

import com.codelabs.poskepulid.BuildConfig


object AppConstant {
    //auth
    const val contentype : String = BuildConfig.CONTENT_TYPE

    //gatewaye
    private const val hostGateway : String = BuildConfig.HOST_GATEWAY
    private const val gatewayMaster : String = BuildConfig.HOST_GATEWAY_API
    private const val apiVersion : String = BuildConfig.AUTH_VERSION
    const val urlMaster : String = ""
}