package com.example.drcafe.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.drcafe.utils.AnswerTypeConverter
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Questions")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @NotNull val question: String,
    val answers: Answer
)

data class Answer(
    val answer: String,
    val points: Int
)
