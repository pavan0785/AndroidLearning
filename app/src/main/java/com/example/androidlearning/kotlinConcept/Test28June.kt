package com.example.androidlearning.kotlinConcept

import com.example.androidlearning.model.UserInfo

fun main() {
//    var name: String? = "Rakesh"
////    name = "Kotlin"
//    name = null




//    println(name!!.length)
    val data = UserInfo("Rakesh", "Sharma");
    val dataCopy = data.copy("A", "B")
    println(data.hashCode())
    println(dataCopy.hashCode())
    println(data.toString())
    println(dataCopy.toString())
    println(data.equals(dataCopy))
    println(data.component1())
    println(data.component2())


}