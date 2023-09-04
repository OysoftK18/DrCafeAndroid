package com.example.drcafe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.drcafe.screens.AddAnswer
import com.example.drcafe.screens.HomeScreen
import com.example.drcafe.screens.AddQuestion
import com.example.drcafe.screens.DataBaseManager
import com.example.drcafe.ui.theme.DrCafeTheme
import com.example.drcafe.utils.AddAnswer
import com.example.drcafe.utils.AddQuestion
import com.example.drcafe.utils.DatabaseManager
import com.example.drcafe.utils.Home
import com.example.drcafe.viewmodels.AppViewModelProvider
import com.example.drcafe.viewmodels.DatabaseManagerViewModel

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
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Home.ROUTE){
                        composable(Home.ROUTE){
                            HomeScreen(navController)
                        }
                        composable(AddQuestion.ROUTE){
                            val viewModel: DatabaseManagerViewModel = viewModel(factory = AppViewModelProvider.factory)
                            AddQuestion(viewModel = viewModel)
                        }
                        composable(DatabaseManager.ROUTE){
                            val viewModel: DatabaseManagerViewModel = viewModel(factory = AppViewModelProvider.factory)
                            DataBaseManager(viewModel.questionState, navController = navController){
                                viewModel.deleteQuestion(it)
                            }
                        }
                        composable(AddAnswer.ROUTE){
                            AddAnswer()
                        }
                    }
                }
            }
        }
    }
}
