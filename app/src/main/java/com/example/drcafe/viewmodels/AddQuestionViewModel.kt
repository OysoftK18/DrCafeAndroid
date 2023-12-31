package com.example.drcafe.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drcafe.database.data.QuizRepository
import com.example.drcafe.database.model.Question
import kotlinx.coroutines.launch

class AddQuestionViewModel(private val quizRepository: QuizRepository) : ViewModel() {
    fun insertQuestion(question: Question) {
        viewModelScope.launch {
            quizRepository.insertQuestion(question = question)
        }
    }
}