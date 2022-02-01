package com.example.mytodolist.ui.tasks

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mytodolist.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TaskFragment : Fragment(R.layout.fragment_tasks) {
    private val viewModel: TasksViewModel by viewModels()

}