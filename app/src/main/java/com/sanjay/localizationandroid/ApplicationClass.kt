package com.sanjay.localizationandroid

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex

open class ApplicationClass:Application (){
    init {
        //AppCompatDelegate ->This class represents a delegate which you can use to extend AppCompat's support to any Activity.
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocalizationManager.setLocale(base))
        MultiDex.install(base)// if you do override the Application class but it's not possible to change the base class, then you can instead override the attachBaseContext() method and callMultiDex.install(this) to enable multidex:
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocalizationManager.setLocale(this)
        Log.d(Constants.ON_CONFIGURATION_CHANGED, "onConfigurationChanged: " + newConfig.locale.language)

    }



}