package com.felipearpa.tent.product.di

import com.felipearpa.tent.product.data.ProductRemoteDataSource
import com.felipearpa.tent.product.data.ProductRemoteRepository
import com.felipearpa.tent.product.data.ProductRepository
import com.felipearpa.tent.product.domain.DefaultFindProductsUseCase
import com.felipearpa.tent.product.domain.FindProductsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ProductUseCaseModule {

    @Binds
    @Singleton
    fun provideFindProductsUseCase(implementation: DefaultFindProductsUseCase): FindProductsUseCase

}

@Module
@InstallIn(SingletonComponent::class)
interface ProductRepositoryModule {

    @Binds
    @Singleton
    fun provideProductRepository(implementation: ProductRemoteRepository): ProductRepository

}

@Module
@InstallIn(SingletonComponent::class)
object ProductDataSourceModule {

    @Provides
    @Singleton
    fun provideProductRemoteDataSource(retrofit: Retrofit): ProductRemoteDataSource =
        retrofit.create(ProductRemoteDataSource::class.java)

}