package com.felipearpa.core.di

import com.felipearpa.core.network.NetworkExceptionHandler
import com.felipearpa.core.network.RetrofitExceptionHandler
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkExceptionProvider {
    @Binds
    @Singleton
    fun provideNetworkExceptionHandler(implementation: RetrofitExceptionHandler): NetworkExceptionHandler
}