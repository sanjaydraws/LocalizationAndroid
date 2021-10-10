package com.sanjay.localizationandroid

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import com.sanjay.localizationandroid.SharedPreferencesHelper.set
import java.util.*


/**
* @author Sanjay Prajapat
* @time 9-Oct-2021 on 11:27 PM
* */
object LocalizationManager {

    var mEnglishFlag = "en"
    var mArabicFlag = "ar"


    fun setLocale(context: Context?): Context? {
        return updateResources(context, getCurrentLanguage(context))
    }

    inline fun setNewLocale(context: Context?, language: String){
        setCurrentLanguage(context, language)
         updateResources(context, language)
    }

    fun getCurrentLanguage(context: Context?): String? {
       return SharedPreferencesHelper.customSharedPref(context)?.getString(Constants.SELECTED_LANGUAGE,null)
    }
    fun setCurrentLanguage(context: Context?,language:String?){
        SharedPreferencesHelper.customSharedPref(context)?.set(Constants.SELECTED_LANGUAGE,language)
    }

    fun updateResources(context: Context?,language: String?):Context?{
        var contextFun = context
        val locale = Locale(language)
        val resources = context?.resources
        var configuration = Configuration(resources?.configuration)
        configuration.setLocale(locale)
        contextFun = context?.createConfigurationContext(configuration)

        return contextFun
    }
}
