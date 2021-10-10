package com.sanjay.localizationandroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

abstract class BaseActivity: AppCompatActivity() {
    protected fun init() {
        initArguments()
        initViews()
        setupListener()
        initObserver()
        loadData()
    }
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocalizationManager.setLocale(newBase))
    }

    abstract fun initArguments()
    abstract fun initViews()
    abstract fun setupListener()
    abstract fun initObserver()
    abstract fun loadData()

}