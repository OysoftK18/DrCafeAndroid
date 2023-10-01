package com.example.drcafe.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drcafe.database.data.QuizRepository
import com.example.drcafe.database.model.Answer
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AddAnswerViewModel(private val quizRepository: QuizRepository) : ViewModel() {
    fun insertAnswer(answer: Answer) {
        viewModelScope.launch {
            quizRepository.insertAnswers(answer = answer)
        }
    }
    fun editAnswer(answer: Answer) {
        viewModelScope.launch {
            quizRepository.updateAnswers(answer = answer)
        }
    }

    fun getAnswer(answer: String): Answer{
        return runBlocking {
            quizRepository.getAnswer(answer)
        }
    }
}