package com.kk.userregisterapp.userregisterapp.di

import android.app.Application

class AppApplication: Application() {

    companion object {
        lateinit var component: AppComponent private set
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .repositoryModule(RepositoryModule())
            .build()

        component.inject(this)
    }
}