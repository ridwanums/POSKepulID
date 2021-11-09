package com.example.ambarrukmo.api

import android.content.Context
import android.content.SharedPreferences


class DataManager {

    private fun putTempString(key:String?, valor:String?){
        Pref.edit().apply {
            putString(key,valor)
            apply()
        }
    }

    private fun getTempString(key:String?) : String?{
        return Pref.getString(key,"")
    }

    private fun putTempBoolean(key:String?, valor:Boolean?){
        if(valor == null)
            return

        Pref.edit().apply {
            putBoolean(key,valor)
            apply()
        }
    }

    private fun getTempBoolean(key:String?) : Boolean{
        return Pref.getBoolean(key,false)
    }

    private fun putTempInt(key:String?, valor:Int?){
        Pref.edit().apply {
            putInt(key,valor ?: 0)
            apply()
        }
    }

    private fun getTempInt(key:String?) : Int?{
        return Pref.getInt(key,0)
    }

    private fun putTempLong(key:String?, valor:Long?){
        Pref.edit().apply {
            putLong(key,valor ?: 0)
            apply()
        }
    }

    private fun getTempLong(key:String?) : Long?{
        return Pref.getLong(key,0)
    }

    fun clear() {
        Pref.edit().clear().apply()
    }

    fun doLogout(){
//        getInstance().marketName = ""
        getInstance().isLogin = false
        getInstance().memberId = ""
        getInstance().userToken = ""
        getInstance().isNotification = false
    }

    var authToken :String? get() {return getTempString(AUTH_TOKEN)} set(value) = putTempString(AUTH_TOKEN,value)
    var userToken :String? get() {return getTempString(USER_TOKEN)} set(value) = putTempString(USER_TOKEN,value)
    var appToken :String? get() {return getTempString(APP_TOKEN)} set(value) = putTempString(APP_TOKEN,value)
    var isLogin :Boolean? get() {return getTempBoolean(IS_LOGIN)} set(value) = putTempBoolean(IS_LOGIN,value)
    var memberId :String? get() {return getTempString(MEMBER_ID)} set(value) = putTempString(MEMBER_ID,value)
    var companyCode :String? get() {return getTempString(COMPANY_CODE)} set(value) = putTempString(COMPANY_CODE,value)
    var shopIsGrid :Boolean? get() {return getTempBoolean(SHOP_IS_GRID)} set(value) = putTempBoolean(SHOP_IS_GRID,value)
    var storeId : String? get() {return getTempString(STORE_ID)} set(value) = putTempString(STORE_ID,value)
    var numberValet : Int? get(){ return getTempInt(NUMBER_VALET)} set(value) = putTempInt(NUMBER_VALET, value)

    var providerLogin :String? get() {return getTempString(PROVIDER_LOGIN)} set(value) = putTempString(PROVIDER_LOGIN,value)
    var promoID :String? get() {return getTempString(PROMO_ID)} set(value) = putTempString(PROMO_ID,value)


    var expiredLogin :Long? get() {return getTempLong(EXPIRED_LOGIN)} set(value) = putTempLong(EXPIRED_LOGIN,value)


    var memberEmail :String? get() {return getTempString(MEMBER_EMAIL)} set(value) = putTempString(MEMBER_EMAIL,value)
    var memberPassword :String? get() {return getTempString(MEMBER_PASSWORD)} set(value) = putTempString(MEMBER_PASSWORD,value)
    var memberName :String? get() {return getTempString(MEMBER_NAME)} set(value) = putTempString(MEMBER_NAME,value)
    var memberImage :String? get() {return getTempString(MEMBER_IMAGE)} set(value) = putTempString(MEMBER_IMAGE,value)
    var memberLat :String? get() {return getTempString(MEMBER_LAT)} set(value) = putTempString(MEMBER_LAT,value)
    var memberLong :String? get() {return getTempString(MEMBER_LONG)} set(value) = putTempString(MEMBER_LONG,value)
    var floormap :String? get() {return getTempString(FLOOR_MAP)} set(value) = putTempString(FLOOR_MAP,value)
    var merchant_id : String? get() {return getTempString(MERCHANT_ID)} set(value) = putTempString(
        MERCHANT_ID, value)

    var languageId :String? get() {return getTempString(LANGUAGE_ID)} set(value) = putTempString(LANGUAGE_ID,value)
    var languageName :String? get() {return getTempString(LANGUAGE_NAME)} set(value) = putTempString(LANGUAGE_NAME,value)

    var isNotification :Boolean? get() {return getTempBoolean(IS_NOTIFICATION)} set(value) = putTempBoolean(IS_NOTIFICATION,value)
    var isFirstInstall :Boolean? get() {return getTempBoolean(IS_FIRST_INSTALL)} set(value) = putTempBoolean(IS_FIRST_INSTALL,value)
    companion object {
        // TODO: CHANGE THIS TO SOMETHING MEANINGFUL


        private const val AUTH_TOKEN = "auth-token"
        private const val USER_TOKEN = "user-token"
        private const val APP_TOKEN = "app-token"
        private const val IS_LOGIN = "is-member"
        private const val MEMBER_ID = "member-id"
        private const val COMPANY_CODE = "company-code"
        private const val NUMBER_VALET = "number-valet"
        private const val FLOOR_MAP = "floor-map"
        private const val MERCHANT_ID = "merchant-id"

        //SOSMED
        private const val PROVIDER_LOGIN = "provider-login"
        private const val PROMO_ID = "promo-id"

        private const val EXPIRED_LOGIN = "expired-login"

        private const val MEMBER_NAME = "member-name"
        private const val MEMBER_IMAGE = "member-image"
        private const val MEMBER_EMAIL = "member-email"
        private const val MEMBER_PASSWORD = "member-password"
        private const val MEMBER_LAT = "member-lat"
        private const val MEMBER_LONG = "member-long"

        private const val SETTINGS_NAME = "default_settings_ambarukmo"


        private const val LANGUAGE_ID = "language-id"
        private const val LANGUAGE_NAME = "language-name"

        private const val IS_NOTIFICATION = "is-notification"
        private const val IS_FIRST_INSTALL = "is-first-install"
        private const val SHOP_IS_GRID = "shop_is_grid"
        private const val STORE_ID = "store_id"

        private lateinit var context: Context
        private lateinit var Pref: SharedPreferences
        fun init(ctx: Context){
            context = ctx
            Pref = context.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE)
        }

        fun getInstance(): DataManager {
            return DataManager()
        }
    }
}