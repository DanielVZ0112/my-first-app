package com.example.helloandroidstudio.exercises

fun main(){
    var name: String = "Daniel"
    var weekDays= arrayOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")
    println(weekDays[0])

    //Bucles para arrays
    for (day in weekDays){
        println(day)
    }

}