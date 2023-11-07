package com.felipearpa.product.list.di

import com.felipearpa.product.domain.ProductRepository
import com.felipearpa.product.list.application.FindProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductListUseCaseProvider {
    @Provides
    @Singleton
    fun provideFindProductsUseCase(productRepository: ProductRepository) =
        FindProductsUseCase(productRepository = productRepository)
}