package com.example.myhiltapplication.di

import android.app.Application
import com.example.myhiltapplication.data.remote.MyApi
import com.example.myhiltapplication.data.repository.MyRepositoryImpl
import com.example.myhiltapplication.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
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
    fun provideMyApi(): MyApi{
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMyRepository(api: MyApi, app: Application): MyRepository{
        return MyRepositoryImpl(api, app)
    }
}