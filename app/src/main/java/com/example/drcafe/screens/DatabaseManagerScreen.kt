package com.example.drcafe.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.drcafe.R
import com.example.drcafe.database.model.Question
import com.example.drcafe.utils.AddAnswer
import com.example.drcafe.utils.AddQuestion
import com.example.drcafe.viewmodels.DatabaseManagerViewModel
import com.example.drcafe.viewmodels.QuestionState

@Composable
fun DataBaseManager(
    questionState: QuestionState,
    navController: NavController,
    viewModel: DatabaseManagerViewModel
) {
    when (questionState) {
        QuestionState.Failed -> Text(text = stringResource(R.string.failed))
        QuestionState.Loading -> Text(text = stringResource(R.string.loading))
        is QuestionState.Success -> SuccessDataBaseLoader(
            questionList = questionState.questionList,
            navController = navController,
            viewModel = viewModel
        ) {
            viewModel.deleteQuestion(
                it
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuccessDataBaseLoader(
    questionList: List<Question> = emptyList(),
    navController: NavController,
    viewModel: DatabaseManagerViewModel,
    removeQuestion: (Question) -> Unit
) {
    var expanded by remember { mutableStateOf(-1) }

    Scaffold(floatingActionButton ={
        SmallFloatingActionButton(onClick = { navController.navigate(AddQuestion.ROUTE) }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.add)
            )
        }
    } ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding(), start = 6.dp, end = 6.dp)
        ) {
            itemsIndexed(questionList) { index, question ->
                Box {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 6.dp)
                    ) {
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                                    .background(color = MaterialTheme.colorScheme.primary)
                                    .padding(10.dp)
                            ) {
                                Text(
                                    modifier = Modifier.weight(1f),
                                    text = stringResource(
                                        id = R.string.number_question,
                                        question.id
                                    ),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                                Text(
                                    modifier = Modifier.weight(2f), text = question.question,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                                Row(modifier = Modifier.weight(2f)) {
                                    Button(onClick = { navController.navigate("${AddAnswer.ROUTE}/${question.id}") }) {
                                        Icon(
                                            imageVector = Icons.Default.Add,
                                            contentDescription = stringResource(R.string.add)
                                        )
                                    }
                                    Button(onClick = { removeQuestion(question) }) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = stringResource(
                                                R.string.delete
                                            )
                                        )
                                    }
                                }
                            }
                            Divider(modifier = Modifier.height(2.dp), color = Color.LightGray)
                            if (expanded == index) {
                                Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.secondary)) {
                                    viewModel.answersListOfQuestion(question = question).forEach {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(10.dp)
                                        ) {
                                            Text(
                                                modifier = Modifier.weight(1f),
                                                text = it.value.toString(),
                                                color = MaterialTheme.colorScheme.onSecondary
                                            )
                                            Text(
                                                modifier = Modifier.weight(2f), text = it.answer,
                                                color = MaterialTheme.colorScheme.onSecondary
                                            )
                                            Row(modifier = Modifier.weight(2f)) {}
                                        }
                                        Divider(
                                            modifier = Modifier.height(1.dp),
                                            color = Color.LightGray
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Icon(
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .size(20.dp)
                            .clickable {
                                expanded = if (expanded == index) -1 else index
                            },
                        imageVector = if (expanded == index) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = stringResource(
                            R.string.delete
                        ),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}