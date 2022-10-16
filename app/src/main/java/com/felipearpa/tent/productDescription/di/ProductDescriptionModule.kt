package com.felipearpa.tent.productDescription.di

import com.felipearpa.tent.productDescription.domain.DefaultFindProductDescriptionUseCase
import com.felipearpa.tent.productDescription.domain.FindProductDescriptionUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ProductDescriptionUseCaseModule {

    @Binds
    @Singleton
    fun provideFindProductDescriptionUseCase(implementation: DefaultFindProductDescriptionUseCase): FindProductDescriptionUseCase

}