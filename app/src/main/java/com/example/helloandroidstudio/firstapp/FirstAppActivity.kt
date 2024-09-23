package com.example.helloandroidstudio.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloandroidstudio.R
import com.example.helloandroidstudio.firstapp.ui.theme.HelloAndroidStudioTheme

class FirstAppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val tvFirstApp = findViewById<TextView>(R.id.TextView01)
        val name: String= intent.extras?.getString("EXTRA_NAME").orEmpty()
        enableEdgeToEdge()
        tvFirstApp.text = "Hola $name"
    }
}

