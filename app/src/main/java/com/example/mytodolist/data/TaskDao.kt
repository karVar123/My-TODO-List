package com.example.mytodolist.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    fun getTasks(query: String, sortOrder: SortOrder, hideCompleted: Boolean): Flow<List<Task>> =
        when (sortOrder) {
            SortOrder.BY_DATE -> getTasksSortedByDateCreated(query, hideCompleted)
            SortOrder.BY_NAME -> getTasksSortedByDateCreated(query, hideCompleted)
        }

    @Query("SELECT * FROM task_table WHERE(completed!=:hideCompleted OR completed=0) AND name LIKE '%'|| :searchQuery ||'%'  ORDER BY completed DESC, name")
    fun getTasksSortedByName(searchQuery: String, hideCompleted: Boolean): Flow<List<Task>>

    @Query("SELECT * FROM task_table WHERE(completed!=:hideCompleted OR completed=0) AND name LIKE '%'|| :searchQuery ||'%'  ORDER BY completed DESC, created")
    fun getTasksSortedByDateCreated(searchQuery: String, hideCompleted: Boolean): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("DELETE FROM TASK_TABLE WHERE completed=1")
    suspend fun deleteCompletedTasks()
}