package com.example.newkotlin

import java.lang.IllegalArgumentException

//Data class
data class User(val id: Long, var name:String)

fun main(){
    //Data class
    val user1 = User(1, "Macy")

//    val name = user1.name
//    println(name)
    user1.name = "Rachel"
    val user2 = User(1, "Rachel")

    println(user1 == user2)
    println("User Details: $user1")

    val updatedUser = user1.copy(name = " Macy Nyakinyua")
    println(user1)
    println(updatedUser)

    println(updatedUser.component1()) // - prints 1
    println(updatedUser.component2()) // - prints Macy Nyakinyua

    val (id, name) = updatedUser
    println("id=$id, name=$name")


    //Lateinit - setters and getters
    var myCar = Car()
    println("My brand is : ${myCar.myBrand}")
    myCar.maxSpeed = 200
    println("Maxspeed is ${myCar.maxSpeed}")
    println("Model is ${myCar.myModel}")

}
open class Car(){
    lateinit var owner : String

    val myBrand : String = "BMW"
        get() {
            return field.toLowerCase()
    }
    var maxSpeed: Int = 250
    //get() = field
    set(value) {
        field = if (value > 0) value else throw IllegalArgumentException("Maxspeed cannot be less than 0")
    }
    var myModel : String = "MarkX"
    private set

    init {
        this.myModel = "MarkX2"
        this.owner = "Moses"
    }

}