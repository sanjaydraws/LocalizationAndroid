package com.sanjay.localizationandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjay.localizationandroid.Constants.SELECTED_LANGUAGE
import com.sanjay.localizationandroid.SharedPreferencesHelper.set
import com.sanjay.localizationandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.apply {
            setContentView(this.root)
        }

        init()
//
//        val sharePref = SharedPreferencesHelper.customSharedPref(context = this)
//        sharePref?.apply {
//            set("name", "Justin")
//            set("age", 23)
//            set("isAdult", true)
//        }
//
//        sharePref?.getString(SELECTED_LANGUAGE,null)

    }
    override fun initArguments() {
    }

    override fun initViews() {
        binding?.currentLanguage?.text = "current Language: ${LocalizationManager.getCurrentLanguage(this.applicationContext)}"
        binding?.languageResult?.text = "${getString(R.string.meter_number)} \n ${getString(R.string.app_name)}" +
                " " + "\n${getString(R.string.meter_number)} ${getString(R.string.howto_read_meter)}"

    }

    override fun setupListener() {
        binding?.arabic?.setOnClickListener {
            LocalizationManager.setNewLocale(this.applicationContext, LocalizationManager.mArabicFlag)
            this.recreate() //recreate activity
        }
        binding?.english?.setOnClickListener {
            LocalizationManager.setNewLocale(this.applicationContext, LocalizationManager.mEnglishFlag)
            this.recreate() //recreate activity
        }
        binding?.spanish?.setOnClickListener {
            LocalizationManager.setNewLocale(this.applicationContext, LocalizationManager.mSpanishFlag)
            this.recreate() //recreate activity
        }

//        binding?.english?.setOnClickListener {
//            val mCurrentLanguage =   LocalizationManager.getCurrentLanguage(this.applicationContext)
//            if(mCurrentLanguage == LocalizationManager.mArabicFlag){
//                LocalizationManager.setNewLocale(this.applicationContext, LocalizationManager.mEnglishFlag)
//            }else if(mCurrentLanguage == LocalizationManager.mEnglishFlag){
//                LocalizationManager.setNewLocale(this.applicationContext, LocalizationManager.mArabicFlag)
//            }else{
//                LocalizationManager.setNewLocale(this.applicationContext, LocalizationManager.mArabicFlag)
//            }
//            this.recreate() //recreate activity
//        }
    }

    override fun initObserver() {

    }
    override fun loadData() {
    }

}