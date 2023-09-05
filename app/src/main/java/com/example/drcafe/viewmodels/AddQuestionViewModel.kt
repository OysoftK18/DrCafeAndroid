package com.example.drcafe.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drcafe.database.data.QuizRepository
import com.example.drcafe.database.model.Answer
import kotlinx.coroutines.launch

class AddQuestionViewModel(val quizRepository: QuizRepository) : ViewModel() {
    fun insertAnswer(answer: Answer) {
        viewModelScope.launch {
            quizRepository.insertAnswers(answer = answer)
        }
    }
}