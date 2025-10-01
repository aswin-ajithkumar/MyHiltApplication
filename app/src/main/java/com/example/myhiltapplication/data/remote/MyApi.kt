package com.example.myhiltapplication.data.remote

import com.example.myhiltapplication.data.remote.models.Todo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MyApi {

    @GET("todos/{id}")
    suspend fun doNetworkCall(@Path("id") id: Int): Response<Todo>
}