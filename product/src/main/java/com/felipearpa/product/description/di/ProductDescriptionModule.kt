package com.felipearpa.product.description.di

import com.felipearpa.product.description.application.FindProductDescriptionUseCase
import com.felipearpa.product.domain.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductDescriptionUseCaseModule {
    @Provides
    @Singleton
    fun provideFindProductDescriptionUseCase(productRepository: ProductRepository) =
        FindProductDescriptionUseCase(productRepository = productRepository)
}