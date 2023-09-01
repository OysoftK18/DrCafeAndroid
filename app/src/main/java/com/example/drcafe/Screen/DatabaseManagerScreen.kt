package com.example.drcafe.Screen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.drcafe.ViewModel.DatabaseManagerViewModel
import com.example.drcafe.database.model.Question

@Composable
fun Testing(viewModel: DatabaseManagerViewModel) {
    Button(onClick = {

        viewModel.insertQuestion(Question(question = "owen?", questionSection = 1))
    }) {
        Text(text = "Testing")
    }
}