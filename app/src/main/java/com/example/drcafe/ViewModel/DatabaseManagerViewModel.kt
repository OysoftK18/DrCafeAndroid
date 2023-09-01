package com.example.drcafe.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drcafe.database.data.QuizRepository
import com.example.drcafe.database.model.Question
import kotlinx.coroutines.launch

class DatabaseManagerViewModel(val quizRepository: QuizRepository): ViewModel() {



    fun insertQuestion(question: Question){
        viewModelScope.launch {
            quizRepository.insertQuestion(question = question)
        }
    }
}