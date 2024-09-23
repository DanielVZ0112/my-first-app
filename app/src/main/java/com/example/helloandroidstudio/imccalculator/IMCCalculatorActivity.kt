package com.example.helloandroidstudio.imccalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.helloandroidstudio.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCCalculatorActivity : ComponentActivity() {
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 60
    private var currentAge: Int = 25
    private var currentHeight: Int = 120

    private lateinit var btnPlusHeight: FloatingActionButton
    private lateinit var btnSubtracHeight: FloatingActionButton
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider

    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var btnSubtracWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var tvAge: TextView
    private lateinit var btnSubtracAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var btnCalculate: Button

    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnPlusHeight = findViewById(R.id.btnPlusHeight)
        btnSubtracHeight = findViewById(R.id.btnSubtracHeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubtracWeight = findViewById(R.id.btnSubtracWeight)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnSubtracAge = findViewById(R.id.btnSubtracAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    @SuppressLint("SetTextI18n")
    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        btnPlusHeight.setOnClickListener {
            currentHeight += 1
            tvHeight.text = "$currentHeight cm"
            rsHeight.values = listOf(currentHeight.toFloat())
        }
        btnSubtracHeight.setOnClickListener {
            currentHeight -= 1
            tvHeight.text = "$currentHeight cm"
            rsHeight.values = listOf(currentHeight.toFloat())
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val decimalFormat = DecimalFormat("#.##")
            currentHeight = decimalFormat.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtracWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubtracAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isComponentSelected: Boolean): Int {
        val genderColor =
            if (isComponentSelected) R.color.background_component_selected else R.color.background_component
        return ContextCompat.getColor(this, genderColor)
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    @SuppressLint("DefaultLocale")
    private fun calculateIMC(): Double {
        if (currentHeight == 0) {
            Log.e("IMC", "Altura no puede ser cero.")
            return -1.0
        }
        val imc =
            currentWeight / ((currentHeight.toDouble() / 100) * (currentHeight.toDouble() / 100))
        return imc
    }

    private fun navigateToResult(result: Double) {
        Log.i(
            "Daniel",
            "Preparando para navegar a ResultimcActivity con IMC: ${String.format("%.2f", result)}"
        )
        val intent = Intent(this, ResultimcActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }
}
