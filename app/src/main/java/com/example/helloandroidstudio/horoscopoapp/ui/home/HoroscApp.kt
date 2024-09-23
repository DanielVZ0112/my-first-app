package com.example.helloandroidstudio.horoscopoapp.ui.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.helloandroidstudio.R
import com.example.helloandroidstudio.databinding.ActivityHoroscAppBinding

class HoroscApp : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}