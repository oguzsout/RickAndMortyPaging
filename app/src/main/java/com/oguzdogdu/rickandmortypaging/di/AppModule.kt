package com.oguzdogdu.rickandmortypaging.di

import com.oguzdogdu.rickandmortypaging.service.ApiService
import com.oguzdogdu.rickandmortypaging.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun retrofitInstance() : ApiService = Retrofit.Builder()
        .baseUrl(provideBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
}