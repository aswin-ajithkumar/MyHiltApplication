package com.example.myhiltapplication.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()//:  NetworkResult<Todo>
}