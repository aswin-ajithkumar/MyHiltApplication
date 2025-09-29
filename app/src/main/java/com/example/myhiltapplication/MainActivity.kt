package com.example.myhiltapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import com.example.myhiltapplication.ui.theme.MyHiltApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHiltApplicationTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun MainScreen() {
    val owner = LocalViewModelStoreOwner.current

    if (owner == null) {
        Text("❌ ViewModelStoreOwner is null")
        return
    }

    val viewModel: MyViewModel = hiltViewModel<MyViewModel>()
    Text("✅ ViewModel loaded: ${viewModel.hashCode()}")
}
