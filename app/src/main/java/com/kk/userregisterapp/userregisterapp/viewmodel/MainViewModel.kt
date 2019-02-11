package com.kk.userregisterapp.userregisterapp.viewmodel

import android.content.Context
import android.databinding.ObservableField
import android.text.TextUtils
import com.kk.userregisterapp.userregisterapp.view.MainNavigator
import com.kk.userregisterapp.userregisterapp.model.UserRepository

class MainViewModel(private val mContext: Context) {

    private var mInstance: MainViewModel? = null
    private var mNavigator: MainNavigator? = null

    private var mRepository: UserRepository = UserRepository()
        .getInstance()

    var mToastText: ObservableField<String> = ObservableField()

    var mName: String? = null
    var mAge: String? = null

    var mResultText: ObservableField<String> = ObservableField()

    init {
        mRepository.setSharedPreferences(mContext.getSharedPreferences(
            "Preferences", Context.MODE_PRIVATE))
    }

    fun getInstance(): MainViewModel {
        if (mInstance == null) {
            mInstance = MainViewModel(mContext)
        }
        return mInstance as MainViewModel
    }

    /**
     * Navigatorのセットアップ
     */
    fun setNavigator(navigator: MainNavigator) {
        mNavigator = navigator
    }

    fun onClickRegister() {
        if (TextUtils.isEmpty(mName) && TextUtils.isEmpty(mAge)) {
            // どちらもなし
            mResultText.set("名前と年齢を入力してください")
        } else if (TextUtils.isEmpty(mName)) {
            // 名前なし
            mResultText.set("名前を入力してください")
        } else if (TextUtils.isEmpty(mAge)) {
            // 年齢なし
            mResultText.set("年齢を入力してください")
        } else {
            // save
            mRepository.saveUserInfo(mName!!, mAge!!)
            mToastText.set("Name: $mName, Age: $mAge で保存しました")
            mResultText.set("保存します. name: $mName, age: $mAge")
        }
    }

    fun getToastText(): ObservableField<String> {
        return mToastText
    }

}