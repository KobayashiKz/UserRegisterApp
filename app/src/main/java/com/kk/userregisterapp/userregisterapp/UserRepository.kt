package com.kk.userregisterapp.userregisterapp

import android.content.SharedPreferences

class UserRepository {

    companion object {
        private const val KEY_USER_NAME: String = "KEY_USER_NAME"
        private const val KEY_USER_AGE: String = "KEY_USER_AGE"
    }

    var mInstance: UserRepository? = null
    var mPreferences: SharedPreferences? = null

    fun getInstance(): UserRepository {
        if (mInstance == null) {
            mInstance = UserRepository()
        }
        return mInstance as UserRepository
    }

    fun saveUserInfo(name: String, age: String) {
        if (mPreferences != null) {
            // Preferencesに保存
            mPreferences!!.edit().putString(KEY_USER_NAME, name).apply()
            mPreferences!!.edit().putString(KEY_USER_AGE, age).apply()
        }
    }

    fun setSharedPreferences(pref: SharedPreferences) {
        mPreferences = pref
    }

}