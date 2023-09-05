package com.example.drcafe.database.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.drcafe.database.model.Answer

@Dao
interface AnswerDao {

    @Query("SELECT * FROM Answers")
    fun getAllAnswers(): List<Answer>

    @Query("SELECT * FROM Answers WHERE questionOwner=:ownerId")
    fun getAnswersFromQuestion(ownerId: Int): List<Answer>

    @Insert
    suspend fun insertAnswers(answer: Answer)
}