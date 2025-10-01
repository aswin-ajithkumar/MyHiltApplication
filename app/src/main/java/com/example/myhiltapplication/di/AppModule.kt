package com.example.myhiltapplication.di

import com.example.myhiltapplication.data.remote.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
/*
SingletonComponent -> dependency live as long as the app lives
ActivityComponent -> dependency live as long as the activity it is injected to
ViewModelComponent -> dependency live as long as the viewmodel
ActivityRetainedComponent -> dependency is not lost if the orientation changes
ServiceComponent -> to inject dependency to a service
*/

object AppModule {

    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
//            .baseUrl("https://test.com")
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }


    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "Hello 2"
}
