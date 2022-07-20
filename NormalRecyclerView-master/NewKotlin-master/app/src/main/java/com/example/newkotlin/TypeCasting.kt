package com.example.newkotlin

fun main(){
    var stringList: List<String> = listOf(
            "Denis", "Frank", "Michael", "Garry")
    val mixedTypeList: List<Any> = listOf(
            "Denis", 30, 5, "BDay", 79.3, "weighs", "Kg")

    for (value in mixedTypeList) {
        if (value is Int) {
            println("Integer: '$value'")
        } else if (value is Double){
            println("Double: '$value' with Floor value ${
                Math.floor(value)}")
        }else if (value is String) {
            println("String: '$value' of length ${
                value.length}")
        }else{
            println("Unknown Type")
        }
    }

    //Alternatively
    for (value in mixedTypeList) {
        when(value) {
            is Int -> println("Integer: $value")
            is Double -> println("Double: $value with Floor value ${Math.floor(value)}")
            is String -> println("String: '$value' of length ${value.length}) ")
            else -> println("Unknown Type")
        }
    }

    //Smart Cast
    val  obj1: Any = "I have a dream"
    if (obj1 !is String) {
        println("Not a String")
    } else {
        //obj is automatically cast to a String in this scope
        println("Found a String of length ${obj1.length}")
    }

    //Explicit (unsafe) Casting using the "as" keyword - can go wrong ---#Gone wrong
    val str1: String = obj1 as String
    println(str1.length)

    val obj2: Any = 1234
    //Gone wrong
//    val str2: String = obj2 as String
//    println(str2)

    //Explicit(safe) casting using the "as?" keyword ----#works
    val obj3: Any = 1234
    val str3: String? = obj3 as? String
    println(str3) //prints null
}