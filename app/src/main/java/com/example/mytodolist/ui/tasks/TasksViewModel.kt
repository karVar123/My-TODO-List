package com.example.mytodolist.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.mytodolist.data.TaskDao

class TasksViewModel @ViewModelInject constructor(
    taskDao: TaskDao
) : ViewModel() {
}