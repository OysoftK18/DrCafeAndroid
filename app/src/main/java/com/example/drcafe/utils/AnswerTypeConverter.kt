package com.example.drcafe.utils

import androidx.room.TypeConverter
import com.example.drcafe.database.model.Answer

class AnswerTypeConverter {

    @TypeConverter
    fun stringToAnswer(value: String): Answer {
        val answer = value.trim().split(",")
        return Answer(answer = answer[0], points = answer[1].toInt())
    }

    @TypeConverter
    fun answerToString(value: Answer): String {
        return "${value.answer},${value.points}"
    }
}