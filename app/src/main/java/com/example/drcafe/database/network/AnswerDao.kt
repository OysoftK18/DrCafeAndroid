package com.example.drcafe.database.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.drcafe.database.model.Answer

@Dao
interface AnswerDao {

    @Query("SELECT * FROM Answers")
    fun getAllAnswers(): List<Answer>

    @Query("SELECT * FROM Answers WHERE questionOwner=:ownerId")
    suspend  fun getAnswersFromQuestion(ownerId: Int): List<Answer>

    @Query("SELECT * FROM Answers WHERE answer=:answer")
    suspend  fun getAnswer(answer: String): Answer

    @Insert
    suspend fun insertAnswers(answer: Answer)

    @Update
    suspend fun updateAnswers(answer: Answer)

    @Query("DELETE FROM Answers WHERE questionOwner=:ownerId")
    suspend  fun deleteAnswersFromQuestion(ownerId: Int)

}