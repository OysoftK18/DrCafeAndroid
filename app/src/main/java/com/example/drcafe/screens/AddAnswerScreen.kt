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
import com.example.drcafe.R
import com.example.drcafe.database.model.Answer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAnswer(answer: Answer = Answer(answer = "", value = 0, questionOwner = 0), questionOwner: Int = 0) {

    var answerText by remember {
        mutableStateOf(answer.answer)
    }
    var answerPoints by remember {
        mutableStateOf(answer.value.toString())
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = answerText,
            onValueChange = { answerText = it },
            label = { Text(text = stringResource(R.string.answer)) }
        )
        OutlinedTextField(
            value = answerPoints,
            onValueChange = { answerPoints = it },
            label = { Text(text = stringResource(R.string.points)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = "Question owner: $questionOwner")
        Button(onClick = {}) {
            Text(text = stringResource(R.string.add_answer))

        }
    }
}