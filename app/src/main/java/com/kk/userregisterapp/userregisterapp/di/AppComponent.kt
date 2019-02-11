package com.kk.userregisterapp.userregisterapp.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class])
interface AppComponent {
    fun inject(app: AppApplication)
}
