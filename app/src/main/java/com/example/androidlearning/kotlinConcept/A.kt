package com.example.androidlearning.kotlinConcept

class A: MyInterface {
    var name: String = "Kotlin"
    var age: Int = 30

    override fun doSomething() {
        print("Do something")
    }
}