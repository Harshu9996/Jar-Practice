package com.example.jarpractice.di

import android.content.Context
import com.example.jarpractice.data.remote.ApiService
import com.example.jarpractice.data.repository.PersonRepository
import com.example.jarpractice.data.repository.PersonRepositoryImpl
import com.example.jarpractice.domain.usecases.GetAllPersonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object Module {


    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context:Context):Retrofit{
        return Retrofit.Builder().baseUrl("https://www.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideApiService(retrofit:Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }


    @Provides
    @Singleton
    fun providePersonRepository(apiService:ApiService):PersonRepository{
        return PersonRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideGetAllPersonUseCase(repository: PersonRepository):GetAllPersonUseCase{
        return GetAllPersonUseCase(repository = repository)
    }


}