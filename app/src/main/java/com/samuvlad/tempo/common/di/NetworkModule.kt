package com.samuvlad.tempo.common.di

import com.samuvlad.tempo.data.api.WeatherApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providerHttpClientBuilder(): OkHttpClient.Builder {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
    }

    @Singleton
    @Provides
    fun provideWeatherRetrofit(httpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl("https://api.openweathermap.org/data/2.5/weather")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun provideWeatherApiClient(retrofit: Retrofit): WeatherApiClient {
        return retrofit.create(WeatherApiClient::class.java)
    }
}