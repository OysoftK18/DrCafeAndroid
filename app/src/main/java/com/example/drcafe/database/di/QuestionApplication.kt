package com.example.drcafe.database.di

import android.app.Application

class QuestionApplication: Application(){

    lateinit var container: QuestionContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultQuestionContainer(this)
    }
}