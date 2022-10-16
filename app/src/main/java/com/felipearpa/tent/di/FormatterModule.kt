package com.felipearpa.tent.di

import com.felipearpa.tent.formatter.ColombianCurrencyFormatter
import com.felipearpa.tent.formatter.CurrencyFormatter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface FormatterModule {

    @Binds
    @Singleton
    fun provideCurrencyFormatter(implementation: ColombianCurrencyFormatter): CurrencyFormatter

}