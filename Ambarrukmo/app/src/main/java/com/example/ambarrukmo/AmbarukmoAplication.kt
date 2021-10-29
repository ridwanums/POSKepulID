package com.example.ambarrukmo

import androidx.multidex.MultiDexApplication
import com.example.ambarrukmo.api.DataManager

class AmbarukmoAplication : MultiDexApplication(){
    override fun onCreate() {
        super.onCreate()
        DataManager.init(applicationContext)
    }
}