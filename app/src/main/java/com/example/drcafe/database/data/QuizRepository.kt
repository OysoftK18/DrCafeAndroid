package com.example.drcafe.database.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.drcafe.database.model.Answer
import com.example.drcafe.database.model.Question
import com.example.drcafe.database.network.AnswerDao
import com.example.drcafe.database.network.QuestionDao

interface QuizRepository {
    /** This is about the Questions*/
    @Query("SELECT * FROM questions")
    suspend fun getAllQuestions(): List<Question>

    @Query("SELECT * FROM questions WHERE id=:id")
    fun getQuestion(id: Int): Question

    @Insert
    suspend fun insertQuestion(question: Question)

    @Delete
    suspend fun removeQuestion(question: Question)

    /** This is about the Answers*/
    @Query("SELECT * FROM Answers")
    fun getAllAnswers(): List<Answer>

    @Query("SELECT * FROM Answers WHERE questionOwner=:ownerId")
    suspend fun getAnswersFromQuestion(ownerId: Int): List<Answer>

    @Insert
    suspend fun insertAnswers(answer: Answer)


}

class OfflineQuizRepository(private val questionDao: QuestionDao, private val answerDao: AnswerDao): QuizRepository{


    /** This is about the Questions*/

    override suspend fun getAllQuestions(): List<Question> = questionDao.getAllQuestions()

    override fun getQuestion(id: Int): Question = questionDao.getQuestion(id)

    override suspend fun insertQuestion(question: Question) = questionDao.insertQuestion(question)

    override suspend fun removeQuestion(question: Question) = questionDao.removeQuestion(question)


    /** This is about the Answers*/
    override fun getAllAnswers(): List<Answer> = answerDao.getAllAnswers()

    override suspend  fun getAnswersFromQuestion(ownerId: Int): List<Answer> = answerDao.getAnswersFromQuestion(ownerId)

    override suspend fun insertAnswers(answer: Answer) = answerDao.insertAnswers(answer = answer)
}