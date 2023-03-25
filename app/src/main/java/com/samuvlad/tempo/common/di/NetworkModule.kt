package com.samuvlad.tempo.common.di

import android.content.Context
import com.samuvlad.tempo.BuildConfig
import com.samuvlad.tempo.data.Repository
import com.samuvlad.tempo.data.api.interfaces.LocationInfoApiClient
import com.samuvlad.tempo.data.api.interfaces.WeatherApiClient
import com.samuvlad.tempo.domain.interfaces.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import com.samuvlad.tempo.data.service.LocationService
import retrofit2.create
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerHttpClientBuilder(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)

        return OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS).build()
    }

    @Singleton
    @Provides
    @Named("RETROFIT_WEATHER")
    fun provideWeatherRetrofit(httpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BuildConfig.HOST_WEATHER)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    @Named("RETROFIT_LOCATION_INFO")
    fun providerInfoLocationRetrofit(httpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BuildConfig.HOST_LOCATION_INFO)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    fun provideWeatherApiClient(@Named("RETROFIT_WEATHER") retrofit: Retrofit): WeatherApiClient {
        return retrofit.create(WeatherApiClient::class.java)
    }

    @Provides
    fun providerInfoLocationApiClient(@Named("RETROFIT_LOCATION_INFO") retrofit: Retrofit): LocationInfoApiClient {
        return retrofit.create(LocationInfoApiClient::class.java)
    }

    @Provides
    fun providerIRepository(weatherApiClient: WeatherApiClient, locationService: LocationService, locationInfoApiClient: LocationInfoApiClient): IRepository {
        return Repository(weatherApiClient, locationService, locationInfoApiClient)
    }
}