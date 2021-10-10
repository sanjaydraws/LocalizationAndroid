package com.sanjay.localizationandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjay.localizationandroid.Constants.SELECTED_LANGUAGE
import com.sanjay.localizationandroid.SharedPreferencesHelper.set

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharePref = SharedPreferencesHelper.customSharedPref(context = this)
        sharePref?.apply {
            set("name", "Justin")
            set("age", 23)
            set("isAdult", true)
        }

        sharePref?.getString(SELECTED_LANGUAGE,null)

    }
    override fun initArguments() {
    }

    override fun initViews() {
    }

    override fun setupListener() {
        
    }

    override fun initObserver() {

    }
    override fun loadData() {
    }

}