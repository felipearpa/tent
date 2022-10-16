package com.felipearpa.tent.productDetail.di

import com.felipearpa.tent.productDetail.domain.DefaultFindProductDetailUseCase
import com.felipearpa.tent.productDetail.domain.FindProductDetailUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ProductUseCaseModule {

    @Binds
    @Singleton
    fun provideFindProductDetailUseCase(implementation: DefaultFindProductDetailUseCase): FindProductDetailUseCase

}