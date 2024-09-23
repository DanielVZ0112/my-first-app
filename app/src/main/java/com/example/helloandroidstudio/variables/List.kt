package com.example.helloandroidstudio.variables

fun main(){
    mutablelist()
}
fun inmutablelist(){
    val readOnly:List<String> = listOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")
    println(readOnly.size)
    println(readOnly)
    println(readOnly.first())
    println(readOnly.last())

    val example = readOnly.filter { it.contains("a") }
    println(example)

    readOnly.forEach {weekDay -> println(weekDay) }
}

fun mutablelist(){
    var weekDays:MutableList<String> = mutableListOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")

    weekDays.add("DanielDay")
    println(weekDays)

}