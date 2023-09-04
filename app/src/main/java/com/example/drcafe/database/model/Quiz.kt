package com.example.drcafe.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Questions")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val question: String,
    val questionSection: Int
)

@Entity(tableName = "Answers")
data class Answer(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val answer: String,
    val value: Int,
    val questionOwner: Int
)
