package com.example.drcafe.database.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.drcafe.database.model.Question

@Dao
interface QuestionDao {

    @Query("SELECT * FROM Questions")
    suspend fun getAllQuestions(): List<Question>

    @Query("SELECT * FROM Questions WHERE id=:id")
    fun getQuestion(id: Int): Question

    @Insert
    suspend fun insertQuestion(question: Question)

    @Delete
    suspend fun removeQuestion(question: Question)
}