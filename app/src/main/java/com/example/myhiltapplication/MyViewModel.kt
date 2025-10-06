package com.example.myhiltapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhiltapplication.data.remote.NetworkResult
import com.example.myhiltapplication.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    val repository: MyRepository
) : ViewModel() {

    /*    private val _todoState = MutableStateFlow(TodoState())

        val todoState: StateFlow<TodoState> = _todoState.asStateFlow()

        data class TodoState(
            val data: Todo? = null,
            val isLoading: Boolean = true,
            val error: String? = null,
        )*/

    init {
        callNetwork() // Auto-load on init
    }

//    fun callNetwork() {
    /*viewModelScope.launch {
        _todoState.value = TodoState(isLoading = true)

        when (val result = repository.doNetworkCall()) {
            is NetworkResult.Success -> {
                println("Success: ${result.data}")
                _todoState.value = TodoState(
                    data = result.data,
                    isLoading = false,
                    error = null
                )
            }
            is NetworkResult.Error -> {
                println("Error: ${result.message}")
                _todoState.value = TodoState(
                    data = null,
                    isLoading = false,
                    error = result.message
                )
            }
            is NetworkResult.Loading -> {
                _todoState.value = TodoState(isLoading = true)
            }
        }
    }*/
//    }

    fun callNetwork() {
        viewModelScope.launch {
            when(val result = repository.doNetworkCall()) {
                is NetworkResult.Success<*> -> {
                    println("Success: ${result.data}")
                }
                is NetworkResult.Error<*> -> {
                    println("Error: ${result.message}")
                }
                is NetworkResult.Loading<*> -> {
                    println("Loading...")
                }
            }
        }
    }
}