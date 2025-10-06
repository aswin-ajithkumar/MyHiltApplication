package com.example.myhiltapplication.data.repository

import android.app.Application
import android.util.Log
import com.example.myhiltapplication.R
import com.example.myhiltapplication.data.remote.MyApi
import com.example.myhiltapplication.domain.repository.MyRepository
import javax.inject.Inject
import javax.inject.Named

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
    @Named("hello2") private val hello1: String,
    @Named("hello1") private val hello2: String,
    private val appContext: Application
) : MyRepository {


//    @Inject
//    @Named("hello2")

    /*fun showGreeting() {
        Log.d("MyCustomClass", greeting)
    }*/

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
        showGreeting()
        printBoth()
    }

    fun printBoth() {
        println("Greeting 1: $hello1")
        println("Greeting 2: $hello2")
    }

    override suspend fun doNetworkCall(){

        println("Net work called......")
        showGreeting()

    }
    fun showGreeting() {
        Log.d("MyCustomClass", "Hello1: $hello1, Hello2: $hello2")

    }
    /*: NetworkResult<Todo>{
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
*/
}

