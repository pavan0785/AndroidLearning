package com.example.androidlearning.kotlinConcept

fun main(args: Array<String>) {
         //val , var
//    var a = 100
//    a = 10000

//    val a = 100
////    a = 10000
//    print(a)

//    var name: String
//    name = "Kotlin"
//    println(name)

//    add(100, 12)
//    val sum = add(100, 12)
//    println(sum)


    val a = A()
    a.doSomething()
////    println(a.name)
////    println(a.age)
//    println("Your name is ${a.name} and your age is ${a.age}")
//    println("Your name is "+a.name+" and age is "+a.age)

//    val a = 20000
//    val b = 3000
//
//    if (a > b){
//        println("$a is bigger")
//    }else{
//        println("$b is bigger")
//    }

//    for(i in 1..100){
//        println(i)
//    }


//    printDay(50)


}


fun add(a: Int,b: Int): Unit{
//    var a = 100
//    var b = 200
//    val sum = a + b
//    println(sum)

    val sum = a + b
//    println(sum)
//    return sum

}


fun printDay(num: Int){
    when(num){
        1 -> {
            print("Monday")
        }
        2 ->{
            println("Tuesday")
        }
        3 ->{
            println("Wednesday")
        }
        4 ->{
            println("Thursday")
        }
        5 -> {
            println("Friday")
        }
        6 -> {
            println("Saturday")
        }
        7 -> {
            println("Sunday")
        }
        else ->{
            println("Invalid input")
        }
    }
}

// variable declaration
// lateinit
// class concept
// loop
// conditional statement
// fun creation
// function call
// inheritance
// interface
