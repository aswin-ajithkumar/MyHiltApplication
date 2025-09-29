package com.example.myhiltapplication.data.remote

import retrofit2.http.GET

interface MyApi {

    @GET("test  ")
    suspend fun doNetworkCall()
}