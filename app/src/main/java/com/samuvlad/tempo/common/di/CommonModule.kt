package com.samuvlad.tempo.common.di

import android.content.Context
import com.samuvlad.tempo.data.Repository
import com.samuvlad.tempo.data.api.interfaces.WeatherApiClient
import com.samuvlad.tempo.data.service.LocationService
import com.samuvlad.tempo.domain.interfaces.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Singleton
    @Provides
    fun providerContext(@ApplicationContext appContext: Context): Context {
        return appContext
    }

    @Singleton
    @Provides
    fun providerLocation(appContext: Context): LocationService {
        return LocationService(appContext)
    }



}