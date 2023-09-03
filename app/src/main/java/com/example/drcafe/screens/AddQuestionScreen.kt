package com.example.drcafe.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.example.drcafe.database.model.Question
import com.example.drcafe.viewmodels.DatabaseManagerViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddQuestion(question: Question = Question(id = 1, question = "", questionSection = 1), viewModel: DatabaseManagerViewModel) {

    var questionText by remember {
        mutableStateOf(question.question)
    }
    var questionLevel by remember {
        mutableStateOf(question.questionSection.toString())
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = questionText,
            onValueChange = { questionText = it },
            label = { Text(text = "Question") }
        )
        OutlinedTextField(
            value = questionLevel,
            onValueChange = { questionLevel = it },
            label = { Text(text = "Level") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = { viewModel.insertQuestion(question = Question(question = questionText, questionSection = questionLevel.toInt())) }) {
            Text(text = "Add question")

        }
    }
}