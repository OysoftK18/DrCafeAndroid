package com.example.drcafe.database.di

import android.content.Context
import com.example.drcafe.database.data.OfflineQuizRepository
import com.example.drcafe.database.data.QuizRepository
import com.example.drcafe.database.data.QuizDatabase

interface QuizContainer {

    val quizRepository: QuizRepository
}

class DefaultQuizContainer(context: Context) : QuizContainer {

    override val quizRepository: QuizRepository by lazy {
        OfflineQuizRepository(
            QuizDatabase.getDatabase(context).questionDao(),
            QuizDatabase.getDatabase(context).answerDao()
        )
    }

}