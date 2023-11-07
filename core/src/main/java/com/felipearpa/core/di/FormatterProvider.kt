package com.felipearpa.core.di

import com.felipearpa.core.formatter.ColombianCurrencyFormatter
import com.felipearpa.core.formatter.CurrencyFormatter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface FormatterProvider {
    @Binds
    @Singleton
    fun provideCurrencyFormatter(implementation: ColombianCurrencyFormatter): CurrencyFormatter
}