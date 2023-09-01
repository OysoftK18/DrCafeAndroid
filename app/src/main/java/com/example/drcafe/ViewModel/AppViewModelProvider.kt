package com.example.drcafe.ViewModel

import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import com.example.drcafe.database.di.QuestionApplication

object AppViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            val cardsRepository = questionApplication().container.quizRepository

            DatabaseManagerViewModel(cardsRepository)
        }
    }
}

fun CreationExtras.questionApplication(): QuestionApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as QuestionApplication)