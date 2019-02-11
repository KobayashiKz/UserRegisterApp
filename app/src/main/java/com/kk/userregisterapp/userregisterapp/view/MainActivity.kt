package com.kk.userregisterapp.userregisterapp.view

import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kk.userregisterapp.userregisterapp.R
import com.kk.userregisterapp.userregisterapp.databinding.ActivityMainBinding
import com.kk.userregisterapp.userregisterapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), MainNavigator {

    private lateinit var mViewModel: MainViewModel
    private lateinit var mToastCallback: Observable.OnPropertyChangedCallback

    private var mDataBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (mDataBinding == null) {
            mDataBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main
            )
        }

        mViewModel = MainViewModel(applicationContext).getInstance()
        mViewModel.setNavigator(this)

        mDataBinding!!.viewmodel = mViewModel

        setupToast()
    }

    private fun setupToast() {
        mToastCallback = object : Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    Toast.makeText(applicationContext,
                        mViewModel.getToastText().get(), Toast.LENGTH_SHORT).show()
                }
        }
        mViewModel.mToastText.addOnPropertyChangedCallback(mToastCallback)
    }
}
