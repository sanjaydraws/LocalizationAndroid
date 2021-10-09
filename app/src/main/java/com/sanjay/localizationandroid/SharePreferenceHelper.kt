package com.sanjay.localizationandroid

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

/**
 * Created By Sanjay Prajapat
 * Date - 4-sept-2021 11:23 PM
 * */
object SharedPreferencesHelper {

    private const val PREFS_PRIVATE_MODE = Context.MODE_PRIVATE

    fun customSharedPref(context: Context?) = context?.getSharedPreferences("mySharedPref", PREFS_PRIVATE_MODE)

    private inline fun SharedPreferences.edit(perform: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        editor.apply {
            perform.invoke(editor)
            apply()
        }
    }

    /**
     * put data in shared preferences
     */
    operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Long -> edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }
//    inline operator fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T? {
//        // as? is a safe cast operator and so it returns null if type cast is failed.
//        // ?: is an elvis operator.
//        return when (T::class) {
//            String::class -> getString(key, defaultValue as? String) as T?
//            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
//            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
//            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
//            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
//            else -> throw UnsupportedOperationException("Not yet implemented")
//        }
//    }

    /**
     * retrieve all values from particular shared preferences
     */
    fun Context?.printAllKeyValuesOfSharedPref(){
        val allEntries: Map<String, *>? = customSharedPref(this)?.all
        if (allEntries != null) {
            for ((key, value) in allEntries) {
                Log.d("mapValues", "$key: $value")
            }
        }
    }

    /**
     * Clears all data in SharedPreferences
     */
    fun SharedPreferences.clearPrefs() {
        edit {
            it.clear()
        }
    }

    /**
     *  it removes keys , will get default value
     * */
    fun SharedPreferences.removeKey(key: String?) {
        edit{
            it.remove(key)
        }
    }

    fun SharedPreferences.containsKey(key: String?): Boolean? {
        return this.contains(key)
    }

//    fun <T> SharedPreferences.setObject(key: String?, objectData:T) {
//        val  jsonValue  = Gson().toJson(objectData)
//        edit{
//            it.putString(key, jsonValue)
//        }
//    }
//    fun <T> SharedPreferences.setObject(key: String?, objectData:T):T? {
//        val  jsonValue  = Gson().fromJson<>(objectData)
//
//    }
}