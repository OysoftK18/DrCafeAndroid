package com.example.drcafe.database.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.drcafe.database.model.Question

@Dao
interface QuestionDao {

    @Query("SELECT * FROM questions")
    fun getAllQuestions(): List<Question>

    @Query("SELECT * FROM questions WHERE id=:id")
    fun getQuestion(id: Int): Question

    @Insert
    fun insertQuestion(question: Question)
}