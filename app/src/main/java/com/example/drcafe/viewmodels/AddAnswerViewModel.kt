package com.example.drcafe.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.drcafe.database.data.QuizRepository
import com.example.drcafe.database.model.Answer
import com.example.drcafe.utils.DatabaseManager
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AddAnswerViewModel(private val quizRepository: QuizRepository) : ViewModel() {
    fun insertAnswer(answer: Answer) {
        viewModelScope.launch {
            quizRepository.insertAnswers(answer = answer)
        }
    }
    fun editAnswer(answer: Answer, navController: NavController) {
        viewModelScope.launch {
            quizRepository.updateAnswers(answer = answer)
            navController.navigate(DatabaseManager.ROUTE)
        }
    }

    fun getAnswer(answer: String): Answer{
        return runBlocking {
            quizRepository.getAnswer(answer)
        }
    }
}