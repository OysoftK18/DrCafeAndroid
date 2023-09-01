package com.example.drcafe.database.di

import android.content.Context
import com.example.drcafe.database.data.OfflineQuestionRepository
import com.example.drcafe.database.data.QuestionRepository
import com.example.drcafe.database.data.QuestionsDatabase

interface QuestionContainer {

    val questionRepository: QuestionRepository
}

class DefaultQuestionContainer(context: Context): QuestionContainer{

    override val questionRepository: QuestionRepository by lazy{
        OfflineQuestionRepository(QuestionsDatabase.getDatabase(context).questionDao())
    }

}