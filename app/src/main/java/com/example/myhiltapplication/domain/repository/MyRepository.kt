package com.example.myhiltapplication.domain.repository

import com.example.myhiltapplication.data.remote.NetworkResult
import com.example.myhiltapplication.data.remote.models.Todo

interface MyRepository {
    suspend fun doNetworkCall():  NetworkResult<Todo>
}