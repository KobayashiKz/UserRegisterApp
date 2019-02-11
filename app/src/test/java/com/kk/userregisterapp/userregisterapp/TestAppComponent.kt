package com.kk.userregisterapp.userregisterapp

import com.kk.userregisterapp.userregisterapp.model.UserRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UserRepository::class])
interface TestAppComponent {
    fun inject(test: ExampleUnitTest)
}