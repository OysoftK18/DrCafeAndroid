package com.example.drcafe.viewmodels

import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import com.example.drcafe.database.di.QuestionApplication

object AppViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            val quizRepository = questionApplication().container.quizRepository

            DatabaseManagerViewModel(quizRepository)
        }

        initializer {
            val quizRepository = questionApplication().container.quizRepository

            AddQuestionViewModel(quizRepository)
        }
    }
}

fun CreationExtras.questionApplication(): QuestionApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as QuestionApplication)