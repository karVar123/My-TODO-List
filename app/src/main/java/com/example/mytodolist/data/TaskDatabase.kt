package com.example.mytodolist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mytodolist.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase() : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope


    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("Hi mom"))
                dao.insert(Task("Hi dear", completed = true))
                dao.insert(Task("Hi brother"))
                dao.insert(Task("Hi sister"))
                dao.insert(Task("Hi friend", completed = true))
                dao.insert(Task("Hi some one"))
            }
        }
    }
}