package com.example.drcafe.database.di

import android.app.Application

class QuestionApplication: Application(){

    lateinit var container: QuizContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultQuizContainer(this)
    }
}