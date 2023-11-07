package com.felipearpa.product.di

import com.felipearpa.product.domain.ProductRemoteDataSource
import com.felipearpa.product.domain.ProductRepository
import com.felipearpa.product.infrastructure.ProductRemoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ProductRepositoryProvider {
    @Binds
    @Singleton
    fun provideProductRepository(implementation: ProductRemoteRepository): ProductRepository
}

@Module
@InstallIn(SingletonComponent::class)
object ProductDataSourceProvider {
    @Provides
    @Singleton
    fun provideProductRemoteDataSource(retrofit: Retrofit): ProductRemoteDataSource =
        retrofit.create(ProductRemoteDataSource::class.java)
}