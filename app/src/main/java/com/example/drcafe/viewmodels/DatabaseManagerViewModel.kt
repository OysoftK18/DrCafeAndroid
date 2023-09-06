package com.example.drcafe.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drcafe.database.data.QuizRepository
import com.example.drcafe.database.model.Answer
import com.example.drcafe.database.model.Question
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception

sealed interface QuestionState {

    data class Success(val questionList: List<Question>) : QuestionState

    object Failed : QuestionState

    object Loading : QuestionState
}

class DatabaseManagerViewModel(private val quizRepository: QuizRepository) : ViewModel() {

    var questionState: QuestionState by mutableStateOf(QuestionState.Loading)
        private set

    init {
        questionState = QuestionState.Loading
        viewModelScope.launch {
            questionState = try {
                QuestionState.Success(quizRepository.getAllQuestions())
            } catch (e: Exception) {
                QuestionState.Failed
            }
        }
    }

    fun deleteQuestion(question: Question) {
        viewModelScope.launch {
            quizRepository.removeQuestion(question = question)
            questionState = try {
                QuestionState.Success(quizRepository.getAllQuestions())
            } catch (e: Exception) {
                QuestionState.Failed
            }
        }
    }

    fun answersListOfQuestion(question: Question): List<Answer> = runBlocking { quizRepository.getAnswersFromQuestion(question.id) }
}