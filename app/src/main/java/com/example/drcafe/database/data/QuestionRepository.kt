package com.example.drcafe.database.data

import androidx.room.Insert
import androidx.room.Query
import com.example.drcafe.database.model.Question
import com.example.drcafe.database.network.QuestionDao

interface QuestionRepository {

    @Query("SELECT * FROM questions")
    fun getAllQuestions(): List<Question>

    @Query("SELECT * FROM questions WHERE id=:id")
    fun getQuestion(id: Int): Question

    @Insert
    fun insertQuestion(question: Question)

}

class OfflineQuestionRepository(private val questionDao: QuestionDao): QuestionRepository{

    override fun getAllQuestions(): List<Question> = questionDao.getAllQuestions()

    override fun getQuestion(id: Int): Question = questionDao.getQuestion(id)

    override fun insertQuestion(question: Question) = questionDao.insertQuestion(question)
}