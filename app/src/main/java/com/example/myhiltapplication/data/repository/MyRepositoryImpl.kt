package com.example.myhiltapplication.data.repository

import android.app.Application
import com.example.myhiltapplication.data.remote.MyApi
import com.example.myhiltapplication.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application
): MyRepository {
    override suspend fun doNetworkCall() {
    }
}