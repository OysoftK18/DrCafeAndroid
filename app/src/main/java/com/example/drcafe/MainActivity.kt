package com.example.drcafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.drcafe.Screen.Testing
import com.example.drcafe.ViewModel.AppViewModelProvider
import com.example.drcafe.ViewModel.DatabaseManagerViewModel
import com.example.drcafe.ui.theme.DrCafeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrCafeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: DatabaseManagerViewModel = viewModel(factory = AppViewModelProvider.factory)
                    Testing(viewModel)
                }
            }
        }
    }
}
