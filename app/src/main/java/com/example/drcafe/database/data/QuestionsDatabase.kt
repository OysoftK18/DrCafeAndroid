package com.example.drcafe.database.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.drcafe.database.model.Question
import com.example.drcafe.database.network.QuestionDao
import com.example.drcafe.utils.AnswerTypeConverter

@Database(entities = [Question::class], version = 1, exportSchema = false)
@TypeConverters(AnswerTypeConverter::class)
abstract class QuestionsDatabase : RoomDatabase() {

    abstract fun questionDao(): QuestionDao

    companion object {

        @Volatile
        private var INSTANCE: QuestionsDatabase? = null

        fun getDatabase(context: Context): QuestionsDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = QuestionsDatabase::class.java,
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