package com.example.helloandroidstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.helloandroidstudio.horoscopoapp.ui.home.HoroscApp
import com.example.helloandroidstudio.imccalculator.IMCCalculatorActivity
import com.example.helloandroidstudio.todoapp.ToDoActivity


class MenuActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnToDo = findViewById<Button>(R.id.btnToDo)
        val btnHoroscopo = findViewById<Button>(R.id.btnHoroscopo)

        btnSaludar.setOnClickListener {
            navigateToSaludarApp()
        }
        btnIMCApp.setOnClickListener {
            navigateToIMCApp()
        }
        btnToDo.setOnClickListener {
            navigateToToDoApp()
        }
        btnHoroscopo.setOnClickListener {
            navigateToHoroscopoApp()
        }
        enableEdgeToEdge()
    }

    private fun navigateToHoroscopoApp() {
        val intent = Intent(this, HoroscApp::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, IMCCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludarApp() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToToDoApp() {
        val intent = Intent(this, ToDoActivity::class.java)
        startActivity(intent)
    }
}
