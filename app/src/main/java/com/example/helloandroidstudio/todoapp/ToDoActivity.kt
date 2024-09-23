package com.example.helloandroidstudio.todoapp

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.helloandroidstudio.R
import com.example.helloandroidstudio.todoapp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoActivity : ComponentActivity() {
    private val categories = listOf(
        Business,
        Personal,
        Other
    )
    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other)
    )

    private lateinit var rvCategorias: RecyclerView
    private lateinit var rvTasks: RecyclerView
    private lateinit var categoriasAdapter: CategoriasAdapter
    private lateinit var tasksAdapter: TaskAdapter

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        initComponent()
        initListeners()
        initUI()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask : Button = dialog.findViewById(R.id.btnAddTask)
        val etTask : EditText = dialog.findViewById(R.id.etTask)
        val rgCategories : RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.business) -> Business
                    getString(R.string.personal) -> Personal
                    else -> Other
                }
                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateTasks() {
        val seletedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { seletedCategories.contains(it.category) }
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }

    private fun initComponent() {
        rvCategorias = findViewById(R.id.rcCategorias)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        categoriasAdapter = CategoriasAdapter(categories){updateCategories(it)}
        rvCategorias.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategorias.adapter = categoriasAdapter
        tasksAdapter = TaskAdapter(tasks){onItemSelected(it)}
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position: Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriasAdapter.notifyItemChanged(position)
        updateTasks()
    }
}
