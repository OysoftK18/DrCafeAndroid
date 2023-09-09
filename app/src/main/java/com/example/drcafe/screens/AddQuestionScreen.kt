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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import com.example.drcafe.R
import com.example.drcafe.database.model.Question
import com.example.drcafe.utils.DatabaseManager
import com.example.drcafe.utils.Home
import com.example.drcafe.viewmodels.AddQuestionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddQuestion(
    question: Question = Question(id = 1, question = "", questionSection = 1),
    viewModel: AddQuestionViewModel,
    navController: NavController
) {

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
            label = {
                if (questionText.isNotBlank()) {
                    Text(text = stringResource(R.string.question))
                } else {
                    Text(text = stringResource(R.string.missing_question))
                }
            }
        )
        OutlinedTextField(
            value = questionLevel,
            onValueChange = { questionLevel = it },
            label = {
                if (questionLevel.isDigitsOnly()) {
                    Text(text = stringResource(R.string.question_section))
                } else {
                    Text(text = stringResource(R.string.level_need_to_be_numbers_only))
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(onClick = {
            if (questionLevel.isDigitsOnly() && questionText.isNotBlank()) {
                viewModel.insertQuestion(
                    Question(
                        question = questionText,
                        questionSection = questionLevel.toInt()
                    )
                )
                navController.navigate(DatabaseManager.ROUTE) {
                    popUpTo(Home.ROUTE)
                }
            }
        }) {
            Text(text = stringResource(R.string.add_question))
        }
    }
}