package com.felipearpa.tent.routing.di

import com.felipearpa.ui.routing.DefaultRouteNavigator
import com.felipearpa.ui.routing.RouteNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoutingModule {

    @Provides
    @Singleton
    fun provideRouteNavigator(): RouteNavigator = DefaultRouteNavigator()

}