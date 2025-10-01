package com.example.myhiltapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.myhiltapplication.ui.theme.MyHiltApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyHiltApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoScreen()
                }
              /*val viewModel = hiltViewModel<MyViewModel>()

                Button(
                    modifier = Modifier.wrapContentSize(),
                    onClick = {
                        viewModel.callNetwork()
                    },
                ){
                    Text(
                        text = "Click Me!.."
                    )
                }*/

            }
        }
    }
}


@Composable
fun TodoScreen(viewModel: MyViewModel = hiltViewModel()) {
    val todoState by viewModel.todoState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            todoState.isLoading -> {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Loading...")
            }

            todoState.error != null -> {
                Text(
                    text = "Error: ${todoState.error}",
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            todoState.data != null -> {
                val todo = todoState.data!!
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Todo Details",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "ID: ${todo.id}")
                        Text(text = "User ID: ${todo.userId}")
                        Text(text = "Title: ${todo.title}")
                        Text(
                            text = "Completed: ${if (todo.completed) "✓" else "✗"}",
                            color = if (todo.completed) Color.Green else Color.Red
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Button(
            onClick = { viewModel.callNetwork() },
            enabled = !todoState.isLoading
        ) {
            Text(text = if (todoState.isLoading) "Loading..." else "Fetch Todo")
        }
    }
}