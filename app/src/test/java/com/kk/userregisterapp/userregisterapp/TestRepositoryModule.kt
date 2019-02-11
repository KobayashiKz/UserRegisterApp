package com.kk.userregisterapp.userregisterapp

import com.kk.userregisterapp.userregisterapp.di.RepositoryModule
import com.kk.userregisterapp.userregisterapp.model.UserRepository
import dagger.Module
import dagger.Provides
import org.mockito.Mockito

@Module
class TestRepositoryModule: RepositoryModule() {
    @Provides
    fun provideUserTestRepository(): UserRepository {
        return Mockito.mock(UserRepository::class.java)
    }
}