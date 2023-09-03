package com.example.drcafe.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.drcafe.utils.DatabaseManager

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Button(onClick = { navController.navigate(DatabaseManager.ROUTE) }) {
            Text(text = "Question database")
        }
    }
}