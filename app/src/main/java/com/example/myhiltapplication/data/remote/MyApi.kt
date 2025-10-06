package com.example.myhiltapplication.data.remote

import retrofit2.http.GET

/*interface MyApi {

    @GET("todos/{id}")
    suspend fun doNetworkCall(@Path("id") id: Int): Response<Todo>
}*/

interface MyApi {

    @GET("test")
    suspend fun doNetworkCall()
}