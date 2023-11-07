package com.felipearpa.product.detail.di

import com.felipearpa.product.description.application.FindProductDescriptionUseCase
import com.felipearpa.product.detail.application.FindProductDetailUseCase
import com.felipearpa.product.domain.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductUseCaseProvider {
    @Provides
    @Singleton
    fun provideFindProductDetailUseCase(
        productRepository: ProductRepository,
        findProductDescriptionUseCase: FindProductDescriptionUseCase
    ) =
        FindProductDetailUseCase(
            productRepository = productRepository,
            findProductDescriptionUseCase = findProductDescriptionUseCase
        )
}