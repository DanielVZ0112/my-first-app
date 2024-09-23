package com.example.helloandroidstudio.exercises
/**
 * En el mundo, se usan tres escalas de temperatura principales: Celsius, Fahrenheit y Kelvin.

En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa
que convierta una temperatura de una escala a otra con estas fórmulas:

De grados Celsius a Fahrenheit: °F = 9/5 (°C) + 32
Kelvin a Celsius: °C = K - 273.15
De Fahrenheit a Kelvin: K = 5/9 (°F - 32) + 273.15
Ten en cuenta que el método String.format("%.2f", /* measurement */ ) se
usa para convertir un número en un tipo String con 2 decimales.
 */


//WIP hacer cuando expliquemos las Lambdas

fun main() {
    println(temperatureConvert("Celsius","Fahrenheit",56.0))
}
fun temperatureConvert(temperatureInit:String,temperatureFinal:String,temperature:Double):String{
    if (temperatureInit == "Celsius" && temperatureFinal == "Fahrenheit"){
        return " La temperatura en Fahrenheit es: " + celsiusToFahrenheit(temperature).toString()
    }else if (temperatureInit == "Celsius" && temperatureFinal == "Kelvin"){
        return " La temperatura en Kelvin es: " + kelvinToCelsius(temperature).toString()
    }else if (temperatureInit == "Fahrenheit" && temperatureFinal == "Kelvin"){
        return " La temperatura en Kelvin es: " + fahrenheitToKelvin(temperature).toString()
    }else if (temperatureInit == "Fahrenheit" && temperatureFinal == "Celsius"){
        return " La temperatura en Celsius es: " + celsiusToFahrenheit(temperature).toString()
    }else if(temperatureInit == "Kelvin" && temperatureFinal == "Celsius"){
        return " La temperatura en Celsius es: " + kelvinToCelsius(temperature).toString()
    }else if(temperatureInit == "Kelvin" && temperatureFinal == "Fahrenheit"){
        return " La temperatura en Fahrenheit es: " + fahrenheitToKelvin(temperature).toString()
    }else{
        return "Las escalas de temperatura no son compatibles"
    }
}

fun celsiusToFahrenheit(celsius: Double): Double {
    return 9.0 / 5.0 * celsius + 32.0
}

fun kelvinToCelsius(kelvin: Double): Double {
    return kelvin - 273.15
}

fun fahrenheitToKelvin(fahrenheit: Double): Double {
    return 5.0 / 9.0 * (fahrenheit - 32.0) + 273.15
}

