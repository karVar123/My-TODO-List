package com.example.mytodolist.ui.addEditTask

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mytodolist.R
import com.example.mytodolist.databinding.FragmentAddEditTaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditTaskFragment : Fragment(R.layout.fragment_add_edit_task) {

    private val viewModel: AddEditTaskViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAddEditTaskBinding.bind(view)

        with(binding) {
            editTextTaskName.setText(viewModel.taskName)
            textViewTaskDateCreated.isVisible = viewModel.task != null
            textViewTaskDateCreated.text = "Created: ${viewModel.task?.createDateFormatted}"
        }
    }
}