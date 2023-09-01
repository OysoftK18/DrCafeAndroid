package com.example.drcafe.database.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.drcafe.database.model.Answer
import com.example.drcafe.database.model.Question
import com.example.drcafe.database.network.AnswerDao
import com.example.drcafe.database.network.QuestionDao

@Database(entities = [Question::class, Answer::class], version = 1, exportSchema = false)
abstract class QuizDatabase : RoomDatabase() {

    abstract fun questionDao(): QuestionDao

    abstract fun answerDao(): AnswerDao

    companion object {

        @Volatile
        private var INSTANCE: QuizDatabase? = null

        fun getDatabase(context: Context): QuizDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = QuizDatabase::class.java,
                    name = "DrCafeQuiz"
                )
                    .fallbackToDestructiveMigration()
                    .build().also {
                        INSTANCE = it
                    }
            }
        }
    }
}