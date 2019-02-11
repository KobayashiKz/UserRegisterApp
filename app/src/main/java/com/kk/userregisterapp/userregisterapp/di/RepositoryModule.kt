package com.kk.userregisterapp.userregisterapp.di

import com.kk.userregisterapp.userregisterapp.model.UserRepository
import dagger.Module
import dagger.Provides

@Module
open class RepositoryModule {
    @Provides
    fun provideUserRepository(): UserRepository {
        return UserRepository()
    }
}