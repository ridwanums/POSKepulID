package com.codelabs.poskepulid.api

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
        getInstance().isLogin = false
    }

    var isLogin :Boolean? get() {return getTempBoolean(IS_LOGIN)} set(value) = putTempBoolean(IS_LOGIN,value)
    var languageId :String? get() {return getTempString(LANGUAGE_ID)} set(value) = putTempString(LANGUAGE_ID,value)

    companion object {

        private const val LANGUAGE_ID = "language"

        private const val IS_LOGIN = "is-member"
        private const val SETTINGS_NAME = "default_settings_kepul"

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