package com.example.helloandroidstudio.imccalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.helloandroidstudio.R
import com.example.helloandroidstudio.imccalculator.IMCCalculatorActivity.Companion.IMC_KEY

class ResultimcActivity : ComponentActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)

        val result = intent.getDoubleExtra(IMC_KEY, -1.0)
        Log.i("Daniel", "IMC recibido en ResultimcActivity: $result")
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {onBackPressedDispatcher.onBackPressed()}
    }

    @SuppressLint("DefaultLocale")
    private fun initUI(result: Double) {
        val formattedResult = String.format("%.2f", result)
        tvIMC.text = formattedResult
        when (result) {
            in 0.00..18.49 -> {
                tvResult.text = getString(R.string.title_low_weight)
                tvResult.setTextColor(getColor(R.color.underweight))
                tvDescription.text = getString(R.string.description_low_weight)
            }
            in 18.50..24.99 -> {
                tvResult.text = getString(R.string.title_normal_weight)
                tvResult.setTextColor(getColor(R.color.normal))
                tvDescription.text = getString(R.string.description_normal_weight)
            }
            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.title_overweight)
                tvResult.setTextColor(getColor(R.color.overweight))
                tvDescription.text = getString(R.string.description_overweight)
            }
            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.title_obesity)
                tvResult.setTextColor(getColor(R.color.obesity))
                tvDescription.text = getString(R.string.description_obesity)
            }
            else -> {
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(getColor(R.color.obesity))
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents() {
        tvResult = findViewById(R.id.tvResult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}
