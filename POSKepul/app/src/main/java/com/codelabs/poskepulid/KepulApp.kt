package com.codelabs.poskepulid

import androidx.multidex.MultiDexApplication
import com.codelabs.poskepulid.api.DataManager

class KepulApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        DataManager.init(applicationContext)
    }
}