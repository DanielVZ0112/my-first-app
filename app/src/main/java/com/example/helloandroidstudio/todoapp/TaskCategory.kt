package com.example.helloandroidstudio.todoapp

sealed class TaskCategory(var isSelected: Boolean = true) {
    object Business : TaskCategory()
    object Personal : TaskCategory()
    object Other : TaskCategory()
}
