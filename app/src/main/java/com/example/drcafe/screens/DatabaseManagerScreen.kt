package com.example.drcafe.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.drcafe.R
import com.example.drcafe.database.model.Question
import com.example.drcafe.viewmodels.QuestionState

@Composable
fun DataBaseManager(questionState: QuestionState, removeQuestion:(Question) -> Unit) {
    when (questionState) {
        QuestionState.Failed -> Text(text = "Failed")
        QuestionState.Loading -> Text(text = "Loading...")
        is QuestionState.Success -> SuccessDataBaseLoader(questionList = questionState.questionList){ removeQuestion(it)}
    }

}

@Composable
fun SuccessDataBaseLoader(questionList: List<Question> = emptyList(), removeQuestion: (Question) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = questionList) { Question ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row {
                    Text(text = stringResource(id = R.string.number_question, Question.id))
                    Text(text = Question.question)
                    Button(onClick = { removeQuestion(Question) }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                    }
                }
            }
        }
    }
}