package com.example.myhiltapplication.data.repository

import android.app.Application
import com.example.myhiltapplication.R
import com.example.myhiltapplication.data.remote.MyApi
import com.example.myhiltapplication.data.remote.NetworkResult
import com.example.myhiltapplication.data.remote.models.Todo
import com.example.myhiltapplication.domain.repository.MyRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
    private val appContext: Application
) : MyRepository {


//    @Inject
//    @Named("hello2")
//    lateinit var greeting: String

    /*fun showGreeting() {
        Log.d("MyCustomClass", greeting)
    }*/

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
//        showGreeting()
    }

    override suspend fun doNetworkCall(): NetworkResult<Todo> {
        return try {
            val response = api.doNetworkCall(1)

            if (response.isSuccessful && response.body() != null) {
                NetworkResult.Success(response.body()!!)
            } else {
                NetworkResult.Error("Error: ${response.message()}")
            }
        } catch (e: HttpException) {
            NetworkResult.Error("HTTP error: ${e.message()}")
        } catch (e: IOException) {
            NetworkResult.Error("Network error: No internet connection")
        }catch (e: Exception) {
            NetworkResult.Error(e.message ?: "An error occurred")
        }
    }
} /*{

        println("Net work called......")
        showGreeting()

    }*/
   /* fun showGreeting() {
        Log.d("MyCustomClass", greeting) // Output: "Hello 2"
    }*/
