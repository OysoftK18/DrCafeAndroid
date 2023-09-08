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
import androidx.navigation.NavController
import com.example.drcafe.R
import com.example.drcafe.database.model.Answer
import com.example.drcafe.utils.DatabaseManager
import com.example.drcafe.utils.Home

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAnswer(navController: NavController, questionOwner: String, addAnswer: (Answer) -> Unit) {

    var answerText by remember {
        mutableStateOf("")
    }
    var answerPoints by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = answerText,
            onValueChange = { answerText = it },
            label = { Text(text = stringResource(R.string.answer)) }
        )
        OutlinedTextField(
            value = answerPoints.toString(),
            onValueChange = { answerPoints = it.toInt() },
            label = { Text(text = stringResource(R.string.points)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = "Question owner: $questionOwner")
        Button(onClick = {
            addAnswer(
                Answer(
                    answer = answerText,
                    value = answerPoints,
                    questionOwner = questionOwner.toInt()
                )
            )
            navController.navigate(DatabaseManager.ROUTE)
        }) {
            Text(text = stringResource(R.string.add_answer))
        }
    }
}